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

}
