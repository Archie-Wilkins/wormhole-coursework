package com.cm6123.wormhole;

import com.cm6123.wormhole.dice.Dice;

import java.util.Scanner;

public class Player {
    /**
     *  Name of player.
     **/
    private String name;
    /**
     * Name of boardPosition.
     **/
    private int boardPosition;
    /**
     * Name of tunrPosition.
     **/
    private final int turnPosition;

    /**
     * Construct a player, with a name, boardPosition(initally 0), turn position.
     *
     * @param name         name of the player.
     * @param turnPosition turn for the player.
     **/
    public Player(final String name, final int turnPosition) {
        this.name = name;
        this.boardPosition = 1;
        this.turnPosition = turnPosition;
    }

    /**
     * @return player name.
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return player board position .
     */
    public int getBoardPosition() {
        return this.boardPosition;
    }

    /**
     * @return player turn position.
     */
    public int getTurnPosition() {
        return this.turnPosition;
    }

    /**
     * Create dice constructor.
     */
    //Need to refactor
    public void createDice(){
        Scanner ui = new Scanner(System.in);
        System.out.println("How many dice faces are you playing with? (Please enter an integer");
        int createDiceInput = 0;
        try {
            createDiceInput = ui.nextInt();
        }catch(Exception e){
            System.out.println("Invalid Input Please enter a number which is greater than 1");
            createDice();
        }
        Dice gameDice = new Dice(createDiceInput);
        System.out.println("Dice Created with " + createDiceInput + " faces.");
    }
}
