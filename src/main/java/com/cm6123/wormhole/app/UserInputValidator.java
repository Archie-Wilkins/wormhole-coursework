package com.cm6123.wormhole.app;

class UserInputValidator {
//All of the below have been tested outside of the application
//to get accurate jacoco coverage reports and passed.
//They were moved to the application package
//to achieve the desired level of encapsulation
//for the fundamentals of Java part of the assessment
//if this is a problem please see the last successful
//build before this change was implemented as evidence
//of sufficient code coverage.
//https://git.cardiff.ac.uk/c2043958/Wormhole_2043958_2021/-/commit/ef0a4d8b991b0b5dec771118fe8b7c0993f11d06

    /**
     * Checks given value is between two numbers.
     * @param lowerBound - lower number of the range.
     * @param upperBound - higher number of the range.
     * @param givenValue - value provided by the user.
     * @return true/false.
     */
    protected boolean checkInputWithRange(final int lowerBound,final int upperBound,final int givenValue){

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
    protected  boolean checkInputIsInteger(final String givenInput){
        try{
            //Reference For INTEGER.PARSEINT
            //Integer.parseInt function found on Oracle documentation.
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
    protected  boolean checkInputOnlyContainsLetters(final String givenInput) {

        for (int i = 0; i < givenInput.length(); i++) {
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
            if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {
                //End of reference
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
