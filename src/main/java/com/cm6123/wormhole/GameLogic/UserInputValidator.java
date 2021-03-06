package com.cm6123.wormhole.GameLogic;

public class UserInputValidator {

    /**
     * Checks given value is between two numbers.
     * @param lowerBound - lower number of the range.
     * @param upperBound - higher number of the range.
     * @param givenValue - value provided by the user.
     * @return true/false.
     */
    public boolean checkInputWithRange(final int lowerBound,final int upperBound,final int givenValue){

          if ((lowerBound <= givenValue) && (givenValue <= upperBound)) {
              return true;
          } else {
              return false;
          }
      }

    /**
     * Checks given value is between two numbers.
     * @param givenInput - value provided by user
     * @return true/false
     */
    public boolean checkInputIsInteger(final String givenInput){
        try{
            //REFERENCE INTEGER.PARSEINT USE HERE
            Integer.parseInt(givenInput);
//https://stackoverflow.com/questions/12558206/how-can-i-check-if-a-value-is-of-type-integer
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * Checks string contains only alphabet letters.
     * @param givenInput - value provided by user
     * @return true/false
     */
    public boolean checkInputOnlyContainsLetters(final String givenInput){

        for(int i = 0; i < givenInput.length(); i++){
            //Reference Chart At to get characters in string.
            char letter = givenInput.charAt(i);
            //REFERENCE THIS FOR LETTER VALIDATION BELOW
            //https://www.programiz.com/java-programming/examples/alphabet
            if((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}







