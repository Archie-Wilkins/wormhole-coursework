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

    //Plan for creating "board"
    //1)Create an array with the same number
    // of spaces as "boardsize x boardsize"
    //2)Populate array with squares
    //3)Convert length amount of squares into
    // Wormhole Entrances (Not at position 0 or position -1)
    //4)Convert length amount of sqaures into
    // Wormhole Exits (Where not Wormhole Entrances or position 0 or -1)

    /**
     * Populates arrayList boardSquares with squares.
     * Number of squares is boardLength x boardLength
     **/
    public void generateBoard() {
        //For loop here to set squares
        final int boardBuffer = 12;
        for (int i = 1; i < this.getBoardLength() + boardBuffer; i++) {
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

    //Take random values from boardSquares
    //set length number to be wormholes entrances
    // and set length number to be wormhole exits
    // where not entrances or position 0 or last position and buffer.
    //Create arrays for both and append each to relevant array
    //

    //Needs testing.
    /**
     * Creates array with squares to be turned into Entrances.
     **/
    public void selectWormHoleEntrances() {
        int numberOfWormHoleEntrances = boardLength;
        while (wormHoleEntranceSquares.size() < boardLength) {
           int selectedSquare = (int) Math.ceil(Math.random() * this.boardSize);
           if ((0 >= selectedSquare) & (selectedSquare >= this.boardSize)) {
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
      int numberOfWormHoleEntrances = boardLength;
      while (wormHoleExitSquares.size() < boardLength) {
          int selectedSquare = (int) Math.ceil(Math.random() * this.boardSize);
          if ((0 >= selectedSquare) & (selectedSquare >= this.boardSize)) {
              //Reference Contains method ---- https://howtodoinjava.com/java/collections/arraylist/arraylist-contains/
              if (!wormHoleEntranceSquares.contains(boardSquares.get(selectedSquare))) {
                  wormHoleEntranceSquares.add(boardSquares.get(selectedSquare));
              }
          }
      }

  }
}




