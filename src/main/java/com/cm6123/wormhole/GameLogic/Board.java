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
    private final int numberOfWormHoles;
    /**
     * ArrayList for squares which make up the board.
     **/
    private ArrayList<Player.Square> boardSquares = new ArrayList<>();

    /**
     * Constructor for board.
     *
     * @param boardLength - length and width of the board.
     *                    Number of Wormholes is equal to the length of the board.
     **/
    public Board(final int boardLength) {
        this.boardLength = boardLength;
        this.numberOfWormHoles = boardLength;
    }

    /**
     * Getter for boardlength.
     *
     * @return boardLength
     **/
    public int getBoardLength() {
        return this.boardLength;
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
            boardSquares.add(new Player.Square(i, SquareType.NORMAL));
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


}
