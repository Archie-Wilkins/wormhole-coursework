package com.cm6123.wormhole.GameLogic;

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
         * @param aSquarePosition - Position of the square within the array.
         * @param initialType - The type of the square
         *       (Normal, Wormhole Entrance Or Wormhole Exit).
         **/
        public Square(final int aSquarePosition, SquareType initialType) {
            this.squarePosition = aSquarePosition;
            this.type = initialType;
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

    /**
     * Setter for square type.
     * @param newType , the SquareType enum value to set the square to.
     **/
        public void setSquareType(SquareType newType) {
           this.type = newType;
        }


}


