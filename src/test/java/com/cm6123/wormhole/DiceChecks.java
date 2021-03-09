package com.cm6123.wormhole;


import com.cm6123.wormhole.dice.Dice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class DiceChecks {
  //Test 1
  @ParameterizedTest
  @ValueSource(ints = {4, 6, 7, 8, 10, 12, 15})
  public void diceNeverExceedsNumberOfFacesOrGoesBelowOne(Integer faces) throws Exception {


    Integer min = 1;
    Integer max = faces;

    Dice aDice = new Dice(faces);

    for (int count = 0; count < 1000; count++) {
      Integer roll = aDice.roll();
      min = min < roll ? min : roll;
      max = max > roll ? max : roll;
    }


    //NOTE: Java autoboxing rules will catch you here! a==b will compare references. a == 1 will unbox and compare values!!!

    assertTrue(max.equals(faces), "max doesn't equal number of faces, but actually equals " + max);
    assertTrue(min.equals(1), "min does't equal 1, but actually equals " + min);

  }
  // Test 2
  @ParameterizedTest
  @ValueSource(ints = {4, 6, 8, 10, 12})
  public void diceRollsEveryValueAtLeastOnce(Integer faces) throws Exception {

    Set<Integer> values = new HashSet<>();

    Dice aDice = new Dice(faces);

    for (int count = 0; count < 1000; count++) {
      values.add(aDice.roll());
    }

    assertTrue(values.size() == faces);
  }
  // Test 3
  @ParameterizedTest
  @ValueSource(ints = {4, 6, 8, 10, 12})
  public void diceRollsEveryValueRoughlyEqually(Integer faces) throws Exception {
    Integer rolls = 1000;

    Map<Integer, Integer> valueCount = new HashMap<>();

    Dice aDice = new Dice(faces);

    for (int count = 0; count < rolls; count++) {
      Integer roll = aDice.roll();
      valueCount.put(roll, valueCount.getOrDefault(roll, 0) + 1);
    }

    for (Integer eachFace = 1; eachFace <= faces; eachFace++) {
      assertTrue(valueCount.get(eachFace) >= rolls / (faces * 2));
    }


  }

  // Test 4
  @ParameterizedTest
  @ValueSource(ints = {4, 6, 8, 10, 12})
  public void getFacesReturnsNumberOfFacesCorrectly(Integer faces) throws Exception {
    Dice aDice = new Dice(faces);
    int diceFaces = aDice.getFaces();
    assertTrue(diceFaces == faces);
  }

}
