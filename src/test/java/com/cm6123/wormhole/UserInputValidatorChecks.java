package com.cm6123.wormhole;

import com.cm6123.wormhole.GameLogic.UserInputValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputValidatorChecks {



    @Test
    public void checkInputWithinRangeCheck() throws Exception{
        UserInputValidator testValidator = new UserInputValidator();

        //Testing lower edge failure case
        assertEquals(testValidator.checkInputWithRange(5,10,4), false);

        //Testing lower edge success case
        assertEquals(testValidator.checkInputWithRange(5,10,5), true);

        //Testing upper edge failure case
        assertEquals(testValidator.checkInputWithRange(5,10, 11), false);

        //Testing upper edge success case
        assertEquals(testValidator.checkInputWithRange(5,10,10), true);
    }

    @Test
    public void checkInputIsIntegerTest() throws Exception{
        UserInputValidator testValidator = new UserInputValidator();

        //Testing lower edge failure case
        assertEquals(testValidator.checkInputIsInteger("4"), true);

        assertEquals(testValidator.checkInputIsInteger("erthesrth"), false);
    }

    @Test
    public void checkInputOnlyContainsLettersTest() throws Exception{
        UserInputValidator testValidator = new UserInputValidator();

        //Testing expected input
        assertEquals(testValidator.checkInputOnlyContainsLetters("HarryPotter"), true);

        //Testing rejecting numbers
        assertEquals(testValidator.checkInputOnlyContainsLetters("5"), false);

        //Testing non-letter symbols
        assertEquals(testValidator.checkInputOnlyContainsLetters("!"), false);

        //Testing Names with spaces
        assertEquals(testValidator.checkInputOnlyContainsLetters("Harry Potter"), false);
    }

}
