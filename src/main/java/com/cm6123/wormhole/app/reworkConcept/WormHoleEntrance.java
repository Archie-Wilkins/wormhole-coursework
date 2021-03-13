package com.cm6123.wormhole.app.reworkConcept;

public class WormHoleEntrance extends Squares {

    /**
     * Constrtuctor for WormHoleEntrance square.
     * @param squarePosition position of square
     */
    public WormHoleEntrance(final int squarePosition){
        super(squarePosition, SquareType.WORMHOLEENTRANCE);
    }

    /**
     * action after player lands on square.
     * square information then square special action.
     */
    public void squareAction(){
        System.out.println("This square's special action "
                +"is moving a player to a random wormhole exit");
    }

    /**
     * square special actions.
     */
    @Override
    public void playerLandsOnSquare(){
        System.out.println("Oh no you've landed on a wormhole.");
    }





}
