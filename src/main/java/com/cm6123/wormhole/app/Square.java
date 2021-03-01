package com.cm6123.wormhole.app;

public class Square {

    /**
     * Position of the square within the array.
     **/
    private final int squarePosition;
    /**
     * The type of the square (Normal, Wormhole Entrance Or Wormhole Exit).
     **/
    private SquareType type;

    /**
     * Constructor For the Square.
     *
     * @param squarePosition - Position of the square within the array.
     * @param type           - The type of the square (Normal, Wormhole Entrance Or Wormhole Exit).
     **/
    public Square(final int squarePosition, SquareType type) {
        this.squarePosition = squarePosition;
        this.type = type;
    }

    /**
     * Getter for square positions.
     *
     * @return squarePosition (position 1-113)
     **/
    public int getSquarePosition() {
        return squarePosition;
    }

    /**
     * Getter for square type.
     *
     * @return squareType (NORMAL,WORMHOLEENTRANCE, WORMHOLEEXIT)
     **/
    public SquareType getSquareType() {
        return type;
    }

    //Square Type Setter Here
}
