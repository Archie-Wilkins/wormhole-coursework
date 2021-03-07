package com.cm6123.wormhole.GameLogic;

//import com.cm6123.wormhole.dice.Dice;
//import java.util.Scanner;

public class Player {
    /**
     * Name of player.
     **/
    private String name;
    /**
     * Name of boardPosition.
     **/
    private int boardPosition;
    /**
     * Whether player use's automatic dice or not.
     **/
    private final boolean automaticDice;

    /**
     *Construct a player, with a name, boardPosition(initally 0), turn position.
     *
     * @param aName         name of the player.
     * @param playerUseAutomaticDice player auto dice or physical dice.
     **/
    public Player(final String aName, final boolean playerUseAutomaticDice) {
        this.name = aName;
        this.boardPosition = 1;
        this.automaticDice = playerUseAutomaticDice;

    }

    /**
     * @return player name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return player board position .
     */
    public int getBoardPosition() {
        return this.boardPosition;
    }

    /**
     * Setter for boardposition.
     * @param newPosition - position player moves to
     */
    public void setBoardPosition(final int newPosition) {
        this.boardPosition = newPosition;
    }
    /**
     * @return player use manual or physical dice.
     */
    public boolean getPlayerUseAutoDice() {
        return this.automaticDice;
    }

}

