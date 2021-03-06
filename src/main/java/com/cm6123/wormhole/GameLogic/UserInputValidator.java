package com.cm6123.wormhole.GameLogic;

public class UserInputValidator {

    public boolean checkInputWithRange(int lowerBound, int upperBound, int givenValue){

          if ((lowerBound <= givenValue) && (givenValue <= upperBound)) {
              return true;
          } else {
              return false;
          }
      }

    public boolean checkInputIsInteger(String givenInput){
        try{
            //REFERENCE INTEGER.PARSEINT USE HERE
            Integer.parseInt(givenInput);
//https://stackoverflow.com/questions/12558206/how-can-i-check-if-a-value-is-of-type-integer
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean checkInputOnlyContainsLetters(String givenInput){

        for(int i = 0; i < givenInput.length(); i++){
            //Reference Chart At to get characters in string.
            char letter = givenInput.charAt(i);
            //REFERENCE THIS FOR LETTER VALIDATION BELOW
            //https://www.programiz.com/java-programming/examples/alphabet
            if((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z') ){
            } else {return false;}
        }
        return true;
    }

}







