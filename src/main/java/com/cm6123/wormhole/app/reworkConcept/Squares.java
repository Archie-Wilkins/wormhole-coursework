package com.cm6123.wormhole.app.reworkConcept;

public abstract class Squares {

    /**
     * position of square within square array.
     */
    private int squarePosition;
    /**
     * Square type from ENUM SquareType.
     */
    private SquareType squareType;

    /**
     * Parent constructor for all squares.
     * @param theSquarePosition - position of square in array.
     * @param theSquareType - squareType from Enum.
     */
    public Squares(final int theSquarePosition,final SquareType theSquareType) {
        this.squarePosition = theSquarePosition;
        this.squareType = theSquareType;
    }

    /**
     * Getter for squarePostiion.
     * @return squarePosition.
     */
    public int getSquarePosition() {
        return squarePosition;
    }

    /**
     * @return squaresType
     */
    public SquareType getSquareType() {
        return squareType;
    }

    /**
     * action to be taken once player lands on square.
     * Square info then specical action
     */
    public abstract void playerLandsOnSquare();

    /**
     * square special actions .
     */
    public abstract void squareAction();
}
