package com.cm6123.wormhole.app;

import com.cm6123.wormhole.GameLogic.Board;
import com.cm6123.wormhole.GameLogic.Player;
import com.cm6123.wormhole.dice.Dice;

import java.util.Scanner;

public class UserInterface {
    //validate input
    //application class only contains main method.
    //p
    Scanner sc = new Scanner(System.in);

    public void playGame() {
        Dice gameDice = new Dice(12);
        System.out.println("Welcome to Wormhole!");

        //VARIOUS CONSTRUCTORS
        createGameBoard();

        int amountOfPlayers = amountOfPlayers();
        int playersCreated = 0;
        while (playersCreated < amountOfPlayers ){
            int playerNumber = playersCreated + 1;
            String playerName = this.namePlayer(playerNumber);
            boolean playerUseAutoDice = this.playerUseAutoDice(playerName);

            Player player = new Player(playerName, playerNumber, playerUseAutoDice);
            playersCreated++;
        }


        //Put Game Sequence Here
        System.out.println("Let's play.");
    }

    public void createGameBoard() {
        //VALIDATOR NEEDED FOR INPUT
        System.out.println("What length board would you like? (5 - 10 squares)");
        //Create validator For this input
        //Ensure int between 5-10 entered
        int boardLength = sc.nextInt();
        Board GameBoard = new Board(boardLength);
        GameBoard.completeBoardGeneration();

        //Give Player infomation on board
        System.out.println("The board has " + GameBoard.getBoardSize() + " squares");
        GameBoard.printWormHolePositions();
    }



    public int amountOfPlayers() {
        System.out.println("How Many Players Would you like? (2-6)");
        int numberOfPlayers = sc.nextInt();
        //VALIDATOR HERE
        return numberOfPlayers;
    }

    public String namePlayer(int playerNumber){
            System.out.println("Please Enter Player " +
                    (playerNumber) + "'s name?");
            String playerName = sc.nextLine();
            //VALIDATOR HERE
            return playerName;
        }

    public boolean playerUseAutoDice(String playerName) {
        //Player use automatic dice yes or no.
        //Unfinished
        boolean playerAutoRollDice = true;

        System.out.println(playerName + " do you want to roll the dice or should " +
                "I do it for you? Type \"Y\" to roll yourself or \"N\" to let me do it.");
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
