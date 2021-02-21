package com.cm6123.wormhole.dice;
import java.util.Scanner; //Importing the scanner class for inputRoll


public class Dice {

  /**
   * The number of faces on this dice.
   */
  private Integer faces;

  /**
   * Construct a dice with the given number of faces.
   *
   * @param numberOfFaces the number of faces that the dice will have.  Dice rolls 1 to this number.
   */
  public Dice(final Integer numberOfFaces) {
    this.faces = numberOfFaces;
  }

  /**
   * Roll to dice to get a value.
   *
   * @return an integer between 1 and the number of faces inclusive.
   */
  public Integer roll() {
    Double tempRoll = Math.ceil(Math.random() * faces.doubleValue());
    return tempRoll.intValue();
  }

  //  User manually input physical dice roll
  // @return the user inputted value between 1 and the number of faces.
  //INCOMPLETE CURRENTLY RETURN ERROR
  //public int inputRoll() {
  //  boolean validInput = false;
  //  Scanner sc = new Scanner(System.in);
  //  int userInputtedRoll;
  //    while (validInput = false) {
  //      System.out.println("Enter Dice Roll Value");
  //      userInputtedRoll = sc.nextInt();
  //      System.out.println(userInputtedRoll);
  //      if (userInputtedRoll > faces) {
  //        System.out.println("Invalid input, dice roll must be less than " + faces);
  //      } else if (userInputtedRoll < 1) {
  //        System.out.println("Invalid input, dice roll must be more than 0" );
  //      } else {
  //      validInput = true;
  //    }

  //   }
  //  return userInputtedRoll;
  // }

}