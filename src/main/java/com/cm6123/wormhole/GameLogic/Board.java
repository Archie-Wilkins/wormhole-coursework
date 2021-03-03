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
    private ArrayList<Square> WormHoleEntranceSquares = new ArrayList<>();
    /**
     * ArrayList for WormHole Exits Within The Board.
     **/
    private ArrayList<Square> WormHoleExitSquares = new ArrayList<>();


    /**
     * Constructor for board.
     *
     * @param boardLength - length and width of the board.
     *                    Number of Wormholes is equal to the length of the board.
     **/
    public Board(final int boardLength) {
        this.boardLength = boardLength;
        this.boardSize = boardLength * boardLength;
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
    //1)Create an array with the same number of spaces as "boardsize x boardsize"
    //2)Populate array with squares
    //3)Convert length amount of squares into Wormhole Entrances (Not at position 0 or position -1)
    //4)Convert length amount of sqaures into Wormhole Exits (Where not Wormhole Entrances or position 0 or -1)

    /**
     * Populates arrayList boardSquares with squares. Number of squares is boardLength x boardLength
     **/
    public void generateBoard() {
        int boardLength = getBoardLength();
        int boardSize = boardLength * boardLength;
        //For loop here to set squares
        for (int i = 1; i < boardSize + 13; i++) { //+12 to boardLength to create excess squares for player to move to if they go over 100
            //add method taken from https://www.tutorialspoint.com/java/util/arraylist_add_index.htm
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
    public int getSquarePosition(int squarePosition) {
        // get method taken from https://howtodoinjava.com/java/collections/arraylist/arraylist-get-method-example/
        return boardSquares.get(squarePosition - 1).getSquarePosition(); //squarePostion -1 because arrays start at 0 but it's more intuitive to call for the exact square you want.
    }

    /**
     * Getter for a squares type.
     *
     * @param squarePosition of the square within the board.
     * @return a squares type (NORMAL, WORMHOLEENTRANCE, WORMHOLEXIT).
     **/
    public Enum<SquareType> getSquareType(int squarePosition) {
        // get method taken from https://howtodoinjava.com/java/collections/arraylist/arraylist-get-method-example/
        return boardSquares.get(squarePosition - 1).getSquareType(); //squarePostion -1 because arrays start at 0 but it's more intuitive to call for the exact square you want.
    }

    //Take random values from boardSquares, set length number to be wormholes entrances
    // and set length number to be wormhole exits where not entrances or position 0 or last position and buffer.
    //Create arrays for both and append each to relevant array
    //

    //Needs testing
    public void selectWormHoleEntrances() {
        int numberOfWormHoleEntrances = boardLength;
        while (WormHoleEntranceSquares.size() < boardLength) {
            int SelectedSquare = (int) Math.ceil(Math.random() * this.boardSize);
            if ((0 >= SelectedSquare) & (SelectedSquare >= this.boardSize)) {
                //Reference .get() method
                WormHoleEntranceSquares.add(boardSquares.get(SelectedSquare));
            }
        }
    }

    //Needs testing
    public void selectWormHoleExits() {
        int numberOfWormHoleEntrances = boardLength;
        while (WormHoleExitSquares.size() < boardLength) {
            int SelectedSquare = (int) Math.ceil(Math.random() * this.boardSize);
            if ((0 >= SelectedSquare) & (SelectedSquare >= this.boardSize)) {
                //Reference Contains method ---- https://howtodoinjava.com/java/collections/arraylist/arraylist-contains/
                if (!WormHoleEntranceSquares.contains(boardSquares.get(SelectedSquare))) {
                    WormHoleEntranceSquares.add(boardSquares.get(SelectedSquare));
                }
            }


        }
    }
}


