package com.cm6123.wormhole.app;

import com.cm6123.wormhole.GameLogic.*;
import com.cm6123.wormhole.dice.Dice;

import java.util.ArrayList;
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
     * Validator Functions.
     */
    private UserInputValidator uiv = new UserInputValidator();

    /**
     * ArrayList to store all players.
     */
    private ArrayList<Player> Players = new ArrayList<>();

    /**
     * Runs the entire sequence of methods.
     * To play the game.
     */
    public void playGame() {
        Dice gameDice = new Dice(12);
        System.out.println("Welcome to Wormhole!");

        //VARIOUS CONSTRUCTORS
        Board gameBoard = createGameBoard();

        int amountOfPlayers = amountOfPlayers();

        //Generate All Players
        int playersCreated = 0;
        while (playersCreated < amountOfPlayers) {
            int playerNumber = playersCreated + 1;
            String playerName = this.namePlayer(playerNumber);
            boolean playerUseAutoDice = this.playerUseAutoDice(playerName);

            Player player = new Player(playerName, playerNumber, playerUseAutoDice);
            Players.add(player);
            playersCreated++;
        }

             //Put Game Sequence Here
            System.out.println("Let's play.");
            boolean playerWon = false;
            while(playerWon == false){
                //Round Summary - Position of all players
                //For each in players array:
                //1) Player Roll Dice
                //2) Player Move
                //3) Player land on square info report
                //4) If player land on a wormhole move player
                //5) If player.getPosition() > BoardSize -- PLAYER WIN

                for (Player p: Players){
                    int playerMoveSquares = 0;

                    //Getting Player Roll
                    if(p.getPlayerUseAutoDice()){
                        playerMoveSquares = gameDice.roll();
                        System.out.println(p.getName() + " rolled a " + playerMoveSquares);
                    }
                    else{
                        //DICE INPUT FUNCTION
                        playerMoveSquares = this.playerDiceInput(p.getName());
                        System.out.println(p.getName() + " rolled a " + playerMoveSquares);
                    }
                    System.out.println(p.getName() + " moved " + playerMoveSquares + " spaces.");

                    //Setting Player New Position.
                    int playerNewPosition = p.getBoardPosition() + playerMoveSquares;
                    p.setBoardPosition(playerNewPosition);
                    System.out.print(p.getName() + " landed on Square " + p.getBoardPosition());

                    //Determining player square type.
                    Square PlayerSquare = gameBoard.getBoardSquares().get(playerNewPosition);
                    SquareType playerSquareType = PlayerSquare.getSquareType();
                    int playerSquarePos = PlayerSquare.getSquarePosition();
                    switch(playerSquareType) {
                        case NORMAL:
                            System.out.println(" which is a normal Square. ");
                            break;
                        case WORMHOLEEXIT:
                            System.out.println(" which is a wormhole exit. ");
                        case WORMHOLEENTRANCE:
                            System.out.println(" which is a wormhole entrance...");
                            int playerExitPosition = gameBoard.getRandomWormholeExitPosition();
                            p.setBoardPosition(playerExitPosition);
                            System.out.println(">>>>>>>>>>> The player has been teleported to square " + p.getBoardPosition());
                            break;
                    }
                    if(p.getBoardPosition() > gameBoard.getBoardSize()){
                        System.out.println(p.getName() + " has WON!!!!!!");
                        playerWon = true;
                        Players.clear();
                        this.playAgain();
                        }

                    }
                }
            }

    private void playAgain() {
        String playerPlayAgain = "";

        System.out.println("Would you like to play again? 'Y' to play again, 'N' to exit game.");
        playerPlayAgain = sc.nextLine();
        switch(playerPlayAgain){
            case "Y":
                this.playGame();
                break;
            case "N":
                System.out.println("Thanks for playing :) ");
                System.out.println("Exiting Game");
                //System.exit Reference
                // https://www.delftstack.com/howto/java/java-end-program/#:~:text=To%20end%20a%20Java%20program,program%20that%20we%20are%20running.
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input, please enter 'Y' or 'N'. ");
                //Clear Array method found here
                // https://beginnersbook.com/2013/12/how-to-empty-an-arraylist-in-java/
                this.playAgain();
        }
    }


    /**
     * Runs all functions needed to generate.
     * A complete board with squares and.
     * Wormhole Entrances and Exits.
     */
    public Board createGameBoard() {
        //VALIDATOR NEEDED FOR INPUT
        String boardLengthInput = "";

        System.out.println("What length board would you like? (5 - 10 squares)");
        boardLengthInput = sc.nextLine();
        if(uiv.checkInputIsInteger(boardLengthInput)){
            int boardLengthNumber = Integer.parseInt(boardLengthInput);
            if (uiv.checkInputWithRange(5,10, boardLengthNumber)){
                Board gameBoard = new Board(boardLengthNumber);
                gameBoard.completeBoardGeneration();


                //Give Player infomation on board
                System.out.println("Thankyou, the board has " + gameBoard.getBoardSize() + " squares");
                gameBoard.printWormHolePositions();
                return gameBoard;
        }else{
                System.out.println("Invalid input, please enter a number "
                        +"between 5 and 10");
                return this.createGameBoard();
            }
        } else{
            System.out.println("Invalid input, please enter a number "
                    +"between 5 and 10");
            return this.createGameBoard();
        }
    }


    /**
     * Asks the player, how many.
     * people will be playing.
     * @return numberOfPlayers
     */
    public int amountOfPlayers() {
        System.out.println("How Many Players Would you like? (2-6)");
        String numberOfPlayers = sc.nextLine();
        if (uiv.checkInputIsInteger(numberOfPlayers)) {
            int numberOfPlayersInteger = Integer.parseInt(numberOfPlayers);
            if (uiv.checkInputWithRange(2, 6, numberOfPlayersInteger)) {
                return numberOfPlayersInteger;
            }
        }
        return amountOfPlayers();
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
                    + (playerNumber) + "'s name? (Letters Only Please, No Spaces)");
            String playerName = sc.nextLine();
            if(uiv.checkInputOnlyContainsLetters(playerName)){
                return playerName;
            }else{
                return this.namePlayer(playerNumber);
            }
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
                playerAutoRollDice = false;
                return playerAutoRollDice;
            case "N":
                System.out.println("Automatic Dice Roll Selected");
                playerAutoRollDice = true;
                return playerAutoRollDice;
            default: return this.playerUseAutoDice(playerName);
        }
    }

    //Need to validate the above

    //Functions For:
    //1) Dice input.
    //2) Square type get and response.
    //3) Player moves.
    //4) Jump to wormHole Exits.
    //5) Player win.
    //6) Play again.
    public int playerDiceInput(String playerName){
        int validInputs = 0;
        int totalDiceValue = 0;
        while(validInputs != 2){
            String rollValue = "";
            System.out.println(playerName + " - Please enter the number on dice " + (validInputs + 1));
            rollValue = sc.nextLine();
            if (uiv.checkInputIsInteger(rollValue)) {
                int rollValueInteger = Integer.parseInt(rollValue);
                if (uiv.checkInputWithRange(1, 6, rollValueInteger)) {
                    totalDiceValue = totalDiceValue + rollValueInteger;
                    validInputs = validInputs + 1;
                }
        }
       }
        return totalDiceValue;
    }


}
