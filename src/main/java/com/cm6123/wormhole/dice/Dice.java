package com.cm6123.wormhole.dice;
//import java.util.Scanner; //Importing the scanner class for inputRoll


public class Dice {

  /**
   * The number of faces on this dice.
   */
  private Integer faces;

  /**
   * Construct a dice with the given number of faces.
   *
   * @param numberOfFaces the number of faces that the dice will have.
   *                    Dice rolls 1 to this number.
   */
  public Dice(final Integer numberOfFaces) {
    this.faces = numberOfFaces;
  }

  /**
   * @return number of faces on dice.
   */
  public int getFaces() {
    return this.faces;
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


  ///NEEDS TO BE CHANGED TO INCORPORATE VALIDATOR
  // Reference https://www.w3schools.com/java/java_try_catch.asp

  //public int userInputRoll(){
  //  Scanner sc = new Scanner(System.in);
  //  System.out.println("Please roll the dice PLAYER XXXXXXXX");
  //  System.out.println("What did you roll? (Enter Number)");
  //  int userInput = 0;
  //  try {
  //    userInput = sc.nextInt();
  //    return userInput;
  //  }catch(Exception e){
  //  System.out.println("Invalid Input Please enter a number betweeen 1 and "
  //  + getFaces());
  //  userInputRoll();
  //   }
  //  return userInput;
  //}
}
