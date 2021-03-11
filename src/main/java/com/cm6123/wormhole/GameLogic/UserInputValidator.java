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

          if((lowerBound <= givenValue) && (givenValue <= upperBound)) {
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
            //Reference For INTEGER.PARSEINT
            //Docs.oracle.com. 2020. Integer (Java Platform SE 7 ). [online]
            // Available at:
           //<https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html>
            // [Accessed 11 March 2021].
            Integer.parseInt(givenInput);
            //End of Reference
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
            //Code used for letter validation.
            //Link to site split over two lines to conform
            //to checkstyles rules
            //Amos, R., 2017. How can I check if a value is of type Integer?.
            // [online] Stack Overflow.
            // Available at:
            // <https://stackoverflow.com/questions/12558206
            // /how-can-i-check-if-a-value-is-of-type-integer>
            // [Accessed 8 March 2021].
            char letter = givenInput.charAt(i);
            if((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')){
            //End of reference
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}







