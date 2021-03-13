package com.cm6123.wormhole.app.reworkConcept;

public class WormholeExit extends Squares {

    /**
     * Constructor for wormhole exit.
     * @param squarePosition - positin of square within array.
     */
    public WormholeExit(final int squarePosition){
        super(squarePosition, SquareType.WORMHOLEEXIT);
    }

    /**
     * action after player lands on square.
     * square information then square special action.
     */
    @Override
    public void playerLandsOnSquare(){
        System.out.println("The player has landed on square" +  this.getSquarePosition()
                +" which is a Wormhole Exit");
    }

    @Override
    public void squareAction(){
    }
}
