package com.cm6123.wormhole.app;

import com.cm6123.wormhole.GameLogic.Board;
import com.cm6123.wormhole.GameLogic.Player;
import com.cm6123.wormhole.GameLogic.Square;
import com.cm6123.wormhole.GameLogic.SquareType;
import com.cm6123.wormhole.dice.Dice;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

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
    private ArrayList<Player> players = new ArrayList<>();

    /**
     * Runs the entire sequence of methods.
     * To play the game.
     */
    public void playGame() {
        Dice gameDice = new Dice(12);
        System.out.println("Welcome to Wormhole!");

        //VARIOUS BOARD SET UP FUNCTIONS
        Board gameBoard = createGameBoard();

        int amountOfPlayers = amountOfPlayers();

        //Generate All Players
        int playersCreated = 0;
        while (playersCreated < amountOfPlayers) {
            int playerNumber = playersCreated + 1;
            String playerName = this.namePlayer(playerNumber);
            boolean playerUseAutoDice = this.playerUseAutoDice(playerName);

            Player player = new Player(playerName, playerUseAutoDice);
            players.add(player);
            playersCreated++;
        }

             //Game Sequence Here
            System.out.println("Let's play.");
            boolean playerWon = false;
            while(playerWon == false){

                for (Player p: players){
                    int playerMoveSquares = 0;

                    //Getting Player Roll
                    if(p.getPlayerUseAutoDice()){
                        playerMoveSquares = gameDice.roll();
                        System.out.println(p.getName() + " rolled a " + playerMoveSquares);
                    } else{
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
                    Square playerSquare = gameBoard.getBoardSquares().get(playerNewPosition);
                    SquareType playerSquareType = playerSquare.getSquareType();
                    int playerSquarePos = playerSquare.getSquarePosition();
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
                        default:
                            System.out.println("Error has occured.");
                    }
                    if(p.getBoardPosition() > gameBoard.getBoardSize()){
                        System.out.println(p.getName() + " has WON!!!!!!");
                        playerWon = true;
                        //Clear Array method found here
                        //Link to site split across two lines to conform
                        //to checkstyles rules
                        //Docs.oracle.com. 2020.
                        // ArrayList (Java Platform SE 7 ). [online]
                        // Available at:
                        // <https://docs.oracle.com/javase/7/
                        // docs/api/java/util/ArrayList.html>
                        // [Accessed 10 March 2021].
                        players.clear();
                        //End of reference
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
                //Link is split across three lines to conform to
                //Checkstyle rules
                //Docs.oracle.com. 2020. System (Java Platform SE 7 ).[online]
                // Available at:
                // <https://docs.oracle.com/javase/7/docs/
                //   api/java/lang/System.html>
                // [Accessed 10 March 2021].
                System.exit(0);
                //End of reference
                break;
            default:
                System.out.println("Invalid Input, please enter 'Y' or 'N'. ");
                this.playAgain();
        }
    }


    /**
     * Runs all functions needed to generate.
     * A complete board with squares and.
     * Wormhole Entrances and Exits.
     * @return generated gameBoard or recalls function.
     */
    private Board createGameBoard() {
        String boardLengthInput = "";

        System.out.println("What length board would you like? (5 - 10 squares)");
        boardLengthInput = sc.nextLine();
        if(uiv.checkInputIsInteger(boardLengthInput)){
            int boardLengthNumber = Integer.parseInt(boardLengthInput);
            if (uiv.checkInputWithRange(5,10, boardLengthNumber)){
                Board gameBoard = new Board(boardLengthNumber);
                gameBoard.completeBoardGeneration();

                //Gives Player infomation on board
                System.out.println("Thankyou, the board has " + gameBoard.getBoardSize() + " squares");
                this.printWormHolePositions(gameBoard);
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
    private int amountOfPlayers() {
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
    private String namePlayer(final int playerNumber){
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
    private boolean playerUseAutoDice(final String playerName) {
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

    /**
     * Asks the player to input the number they rolled.
     * @param playerName - Used to identify to the players
     *                   who needs to roll the dice.
     * @return totalDiceValue.
     */
    private int playerDiceInput(final String playerName){
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

    /**
     * Prints positions of all wormhole.
     * entrances and exits of Gameboard.
     * @param selectedBoard - type Board
     */
    private void printWormHolePositions(final Board selectedBoard){
        String entrances = "";
        String exits = "";
        int arrayLength = selectedBoard.getWormHoleExitSquares().size();
        for (Square s1: selectedBoard.getWormHoleExitSquares()) {
            if (s1 == selectedBoard.getWormHoleExitSquares().get(arrayLength-1)) {
                exits = exits + s1.getSquarePosition() + ".";
            } else {
                exits = exits + s1.getSquarePosition() + ",";
            }
        }
            for (Square s2 : selectedBoard.getWormHoleEntranceSquares()) {
                if (s2 == selectedBoard.getWormHoleEntranceSquares().get(arrayLength-1)) {
                    entrances = entrances + s2.getSquarePosition() + ".";
                } else {
                    entrances = entrances + s2.getSquarePosition() + ",";
                }
            }
                System.out.println("WormHole Entrances are on squares: " + entrances);
                System.out.println("WormHole Exits are on squares: " + exits);
            }

}
