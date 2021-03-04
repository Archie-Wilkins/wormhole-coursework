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
        final int boardBuffer = 13;
        //Tests showed mistake where I put getBoardLength() not size
        for (int i = 1; i < this.getBoardSize() + boardBuffer; i++) {
            //+12 to boardLength to create excess squares
            // for player to move to if they go over 100
            //add method taken from
            // https://www.tutorialspoint.com/java/util/arraylist_add_index.htm
            boardSquares.add(new Square(i, SquareType.NORMAL));
            // System.out.println(i); //For testing
        }

    }

    /**
     * Getter for board position of a square.
     *
     * @param squarePosition of the square within the board.
     * @return The board position of a square.
     **/
    public int getSquarePosition(final int squarePosition) {
 // get method taken from
// https://howtodoinjava.com/java/collections/arraylist/arraylist-get-method-example/
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
        // get method taken from
        // https://howtodoinjava.com/java/collections/arraylist/arraylist-get-method-example/
        return boardSquares.get(squarePosition - 1).getSquareType();
        //squarePostion -1 because arrays start at 0
        //but it's more intuitive to call for the exact square you want.
    }

    //Needs testing.
    /**
     * Creates array with squares to be turned into Entrances.
     **/
    public void selectWormHoleEntrances() {
        //Reference .size() method
        while (wormHoleEntranceSquares.size() < this.getBoardLength()) {
           int selectedSquare = (int) Math.ceil(Math.random() * this.boardSize);
           if ((0 <= selectedSquare) & (selectedSquare <= this.boardSize)) {
           //Reference .get() method
           wormHoleEntranceSquares.add(boardSquares.get(selectedSquare));
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
          if ((0 <= selectedSquare) & (selectedSquare <= this.boardSize)) {
              //Reference Contains method ---- https://howtodoinjava.com/java/collections/arraylist/arraylist-contains/
              if (checkSquareInEntranceList(selectedSquare) == true) {
                  wormHoleExitSquares.add(boardSquares.get(selectedSquare));
              }
          }
      }

  }

  public void ConvertSquareTypes(){
      for (Square s: this.wormHoleEntranceSquares){
          s.setSquareType(SquareType.WORMHOLEENTRANCE);
      }
      for (Square s: this.wormHoleExitSquares){
          s.setSquareType(SquareType.WORMHOLEEXIT);
      }
  }

  public boolean checkSquareInEntranceList(int selectedSquare){
       for (Square entrance: this.getWormHoleEntranceSquares()){
            if(boardSquares.get(selectedSquare).equals(entrance)){
                return false;
         }
       }
      return true;
  }

}






