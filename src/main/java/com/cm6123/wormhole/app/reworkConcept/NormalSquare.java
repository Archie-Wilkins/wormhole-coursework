package com.cm6123.wormhole.app.reworkConcept;

public class NormalSquare extends Squares {

    /**
     * Constrtuctor for normal square.
     * @param squarePosition position of square
     */
    public NormalSquare(final int squarePosition){
        super(squarePosition, SquareType.NORMAL);
    }

    /**
     * action after player lands on square.
     * square information then square special action.
     */
    @Override
    public void playerLandsOnSquare(){
        System.out.println("You've landed on a normal square.");
    }

    /**
     * square special actions.
     */
    @Override
    public void squareAction(){
    }

}
