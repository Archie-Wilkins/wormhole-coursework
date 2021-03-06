package com.cm6123.wormhole.app;

import com.cm6123.wormhole.GameLogic.Board;
import com.cm6123.wormhole.GameLogic.Player;
import com.cm6123.wormhole.dice.Dice;

import java.util.Scanner;

public class UserInterface {
    //validate input
    //application class only contains main method.
    //p

    /**
     * Scanner for all user input.
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * Runs the entire sequence of methods.
     * To play the game.
     */
    public void playGame() {
        Dice gameDice = new Dice(12);
        System.out.println("Welcome to Wormhole!");

        //VARIOUS CONSTRUCTORS
        createGameBoard();

        int amountOfPlayers = amountOfPlayers();
        int playersCreated = 0;
        while (playersCreated < amountOfPlayers){
            int playerNumber = playersCreated + 1;
            String playerName = this.namePlayer(playerNumber);
            boolean playerUseAutoDice = this.playerUseAutoDice(playerName);

            Player player = new Player(playerName, playerNumber, playerUseAutoDice);
            playersCreated++;
        }


        //Put Game Sequence Here
        System.out.println("Let's play.");
    }

    /**
     * Runs all functions needed to generate.
     * A complete board with squares and.
     * Wormhole Entrances and Exits.
     */
    public void createGameBoard() {
        //VALIDATOR NEEDED FOR INPUT
        System.out.println("What length board would you like? (5 - 10 squares)");
        //Create validator For this input
        //Ensure int between 5-10 entered
        int boardLength = sc.nextInt();
        Board gameBoard = new Board(boardLength);
        gameBoard.completeBoardGeneration();

        //Give Player infomation on board
        System.out.println("The board has " + gameBoard.getBoardSize() + " squares");
        gameBoard.printWormHolePositions();
    }


    /**
     * Asks the player, how many.
     * people will be playing.
     * @return numberOfPlayers
     */
    public int amountOfPlayers() {
        System.out.println("How Many Players Would you like? (2-6)");
        int numberOfPlayers = sc.nextInt();
        //VALIDATOR HERE
        return numberOfPlayers;
    }

    /**
     * Asks the player to input their name.
     * @param playerNumber - number to identify
     *                     player (also used to mark their
     *                     turn).
     * @return playerName.
     */
    public String namePlayer(final int playerNumber){
            System.out.println("Please Enter Player "
                    + (playerNumber) + "'s name?");
            String playerName = sc.nextLine();
            //VALIDATOR HERE
            return playerName;
        }

    /**
     * Asks the player whether they'd like to use the
     * auto dice or not.
     * @param playerName
     * @return playerAutoRollDice - Use auto dice = true.
     * Use Manual dice = false.
     */
    public boolean playerUseAutoDice(final String playerName) {
        //Player use automatic dice yes or no.
        //Unfinished
        boolean playerAutoRollDice = true;

        System.out.println(playerName + " do you want to roll the dice or should "
                + "I do it for you? Type \"Y\" to roll yourself or \"N\" to let me do it.");
        String playerAutoRollDiceInput = sc.nextLine();
        switch (playerAutoRollDiceInput) {
            case "Y":
                System.out.println("Manual Dice Roll Selected");
                playerAutoRollDice = true;
                return playerAutoRollDice;
            case "N":
                System.out.println("Automatic Dice Roll Selected");
                playerAutoRollDice = false;
                return playerAutoRollDice;
            default: playerUseAutoDice(playerName);
        }
         return playerAutoRollDice;
    }





}
