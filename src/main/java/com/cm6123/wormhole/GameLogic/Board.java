package com.cm6123.wormhole.GameLogic;

import java.util.ArrayList;

public class Board {

    /**
     * Width and Length of the board.
     **/
    private final int boardLength;
    /**
     * Number of wormhole entrances and exits on the board.
     **/
    private final int boardSize;
    /**
     * ArrayList for squares which make up the board.
     **/
    private ArrayList<Square> boardSquares = new ArrayList<>();
    /**
     * ArrayList for WormHole Entrances Within The Board.
     **/
    private ArrayList<Square> wormHoleEntranceSquares = new ArrayList<>();
    /**
     * ArrayList for WormHole Exits Within The Board.
     **/
    private ArrayList<Square> wormHoleExitSquares = new ArrayList<>();


    /**
     * Constructor for board.
     *
     * @param gameBoardLength - length and width of the board.
     * Number of Wormholes is equal to the length of the board.
     **/
    public Board(final int gameBoardLength) {
        this.boardLength = gameBoardLength;
        this.boardSize = gameBoardLength * gameBoardLength;
    }


    /**
     * Getter for boardlength.
     *
     * @return boardLength
     **/
    public int getBoardLength() {
        return this.boardLength;
    }

    /**
     * Getter for boardSize.
     *
     * @return boardSize.
     **/
    public int getBoardSize() {
        return this.boardSize;
    }

    /**
     * Getter for WormHoleEntrances.
     *
     * @return WormHoleEntrances ArrayList.
     **/
    public ArrayList<Square> getBoardSquares(){
        return boardSquares;
    }

    /**
     * Getter for WormHoleEntrances.
     *
     * @return WormHoleEntrances ArrayList.
     **/
    public ArrayList<Square> getWormHoleEntranceSquares(){
    return wormHoleEntranceSquares;
    }

    /**
     * Getter for WormHoleExits.
     *
     * @return WormHoleExits ArrayList.
     **/
    public ArrayList<Square> getWormHoleExitSquares(){
        return wormHoleExitSquares;
    }


    /**
     * Populates arrayList boardSquares with squares.
     * Number of squares is boardLength x boardLength
     **/
    public void generateBoard() {
        //For loop here to set squares
        final int boardBuffer = 50;
        //Automated test highlighted mistake
        // where I put getBoardLength() not size
        for (int i = 1; i < this.getBoardSize() + boardBuffer; i++) {
            //+50 to boardLength to create excess squares
            // for player to move to if they go over 100s
            boardSquares.add(new Square(i, SquareType.NORMAL));
        }

    }

    /**
     * Getter for board position of a square.
     *
     * @param squarePosition of the square within the board.
     * @return The board position of a square.
     **/
    public int getSquarePosition(final int squarePosition) {
        return boardSquares.get(squarePosition - 1).getSquarePosition();
        //squarePostion -1 because arrays start at 0 but
        // it's more intuitive to call for the exact square you want.
    }

    /**
     * Getter for a squares type.
     *
     * @param squarePosition of the square within the board.
     * @return a squares type (NORMAL, WORMHOLEENTRANCE, WORMHOLEXIT).
     **/
    public Enum<SquareType> getSquareType(final int squarePosition) {
        return boardSquares.get(squarePosition - 1).getSquareType();
        //squarePostion -1 because arrays start at 0
        //but it's more intuitive to call for the exact square you want.
    }

    /**
     * Creates array with squares to be turned into Entrances.
     **/
    public void selectWormHoleEntrances() {
        while (wormHoleEntranceSquares.size() < this.getBoardLength()) {
           int selectedSquare = (int) Math.ceil(Math.random() * this.boardSize);
           if ((1 < selectedSquare) && (selectedSquare < this.boardSize - 1)) {
               if(this.checkSquareInEntranceList(selectedSquare) == true) {
                   wormHoleEntranceSquares.add(boardSquares.get(selectedSquare));
               }
           }
        }
    }

    //Needs testing.
    /**
     * Creates array with squares to be turned into Exits.
     **/
  public void selectWormHoleExits() {
      while (wormHoleExitSquares.size() < this.getBoardLength()) {
          int selectedSquare = (int) Math.ceil(Math.random() * this.boardSize);
          if ((0 < selectedSquare) & (selectedSquare < this.boardSize -1)) {
              if ((this.checkSquareInEntranceList(selectedSquare) == true) && (this.checkSquareNotAlreadyInExitList(selectedSquare))) {
                  wormHoleExitSquares.add(boardSquares.get(selectedSquare));
              }
          }
      }
  }

    /**
     * Converts all squares in Entrance and Exits arrays.
     * To appropriate Square types.
     */
  public void convertSquareTypes(){
      for (Square s: this.getWormHoleEntranceSquares()){
          s.setSquareType(SquareType.WORMHOLEENTRANCE);
      }
      for (Square s: this.getWormHoleExitSquares()){
          s.setSquareType(SquareType.WORMHOLEEXIT);
      }
  }

    /**
     * Used to check no squares are being added to entrances or.
     * exits are already presesnt in entrances.
     * @param selectedSquare selected by SelectExitSquares Function.
     * @return true or false.
     */
  public boolean checkSquareInEntranceList(final int selectedSquare){
       for (Square entrance: this.getWormHoleEntranceSquares()){
            if(boardSquares.get(selectedSquare).equals(entrance)){
                return false;
         }
       }
      return true;
  }
    /**
     * Used to check no squares are being added to entrances or.
     * exits are already presesnt in exits.
     * @param selectedSquare selected by SelectExitSquares Function.
     * @return true or false.
     */
  public boolean checkSquareNotAlreadyInExitList(final int selectedSquare){
      for (Square exit: this.getWormHoleExitSquares()){
          if(boardSquares.get(selectedSquare).equals(exit)){
              return false; //false = failure.
          }
      }
      return true;
  }

    /**
     * Retrieves a randomly selected wormhole exits position.
     * @return randomSquarePosition (int)
     */
  public int getRandomWormholeExitPosition(){
      int randomNumber = (int)Math.ceil(Math.random() * this.getWormHoleExitSquares().size());
      Square randomSquare = this.getWormHoleExitSquares().get(randomNumber -1);
      return randomSquare.getSquarePosition();
  }


    /**
     * Runs all functions needed to generate.
     * A complete board with squares and.
     * Wormhole Entrances and Exits.
     */
  public void completeBoardGeneration() {
      this.generateBoard();
      this.selectWormHoleEntrances();
      this.selectWormHoleExits();
      this.convertSquareTypes();
  }

}






