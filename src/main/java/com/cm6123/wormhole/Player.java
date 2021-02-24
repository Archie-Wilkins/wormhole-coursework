package com.cm6123.wormhole;

import com.cm6123.wormhole.dice.Dice;

import java.util.Scanner;

public class Player {

    //Need to set attributes and constructors 



    //  User manually input physical dice roll
    // @return the user inputted value between 1 and the number of faces.

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
