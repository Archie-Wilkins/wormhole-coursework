package com.cm6123.wormhole;

import com.cm6123.wormhole.GameLogic.Board;
import com.cm6123.wormhole.GameLogic.Square;
import com.cm6123.wormhole.GameLogic.SquareType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardChecks {

    @ParameterizedTest
    @CsvSource({"1,0", "64,63", "99,98" ,"100,99" ,"113,112"})
    public void BoardGeneratesSquaresWithCorrectPositions(int input, int expected) throws Exception {
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();

        //Square position is -1 from intutive answer due to
        //accomdating for lists starting from 0.
        int SquarePosition1 = TestBoard.getSquarePosition(input);
        assertEquals(SquarePosition1, expected);

    }

    @ParameterizedTest
    @ValueSource(ints = {1,64,99,100,112})
    public void BoardGeneratesSquaresWithEnumOfNormal(int input) throws Exception {
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();

        assertEquals(TestBoard.getSquareType(input), SquareType.NORMAL);
    }

    @Test
    public void GetBoardSizeReturnsCorrectSize() throws Exception {
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();

        int boardSize = TestBoard.getBoardSize();
        assertEquals(boardSize, 100);
    }

    @Test
    public void WormHoleEntranceSquaresFilledWithCorrectNumberValidOfItems() throws Exception{
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();
        TestBoard.selectWormHoleEntrances();

        assertEquals(TestBoard.getWormHoleEntranceSquares().size(), 10);

    }

    @Test
    public void WormHoleEntranceSquaresFilledWithSquaresOfTypeNormal() throws Exception {
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();
        TestBoard.selectWormHoleEntrances();
        assertEquals(TestBoard.getWormHoleEntranceSquares().get(3).getSquareType(), SquareType.NORMAL);
    }

    @Test
    public void WormHoleExitSquaresFilledWithCorrectNumberValidOfItems() throws Exception{
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();
        TestBoard.selectWormHoleExits();

        assertEquals(TestBoard.getWormHoleExitSquares().size(), 10);

    }

    @Test
    public void WormHoleExitSquaresFilledWithSquaresOfTypeNormal() throws Exception {
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();
        TestBoard.selectWormHoleExits();
        assertEquals(TestBoard.getWormHoleExitSquares().get(3).getSquareType(), SquareType.NORMAL);
    }
    //Need to create test to make sure there is no overlap between
    //Entrances and Exits
    @Test
    public void WormHoleEntranceSquaresAndExitSquaresHaveUniqueValues() throws Exception {
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();
        TestBoard.selectWormHoleEntrances();
        TestBoard.selectWormHoleExits();


        boolean allValuesUnique = true;
        for (Square entrance: TestBoard.getWormHoleEntranceSquares()){
            for (Square exit: TestBoard.getWormHoleExitSquares()){
                if(entrance.equals(exit)){
                    allValuesUnique = false;
                }
            }
           }
        assertEquals(allValuesUnique, true);
    }

    @Test
    public void WormHoleEntranceSquaresAndExitSquaresHaveUniqueValuesCHECKINGTESTFAILS() throws Exception {
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();

        TestBoard.getWormHoleEntranceSquares().add(TestBoard.getBoardSquares().get(1));
        TestBoard.getWormHoleExitSquares().add(TestBoard.getBoardSquares().get(1));

        boolean allValuesUnique = true;
        for (Square s: TestBoard.getWormHoleEntranceSquares()){
            boolean overLappingValues = TestBoard.getWormHoleExitSquares().contains(s);
            if(overLappingValues = true){
                allValuesUnique = false;
            }
        }
        assertEquals(allValuesUnique, false);
    }

    //Need to make tests to check first and ending squares arent coverted
    //Need to make method to convert items into array to relevant SquareType.
    @Test
    public void CheckWormHoleEntrancesConvertedToTypeEntrance() throws Exception {
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();
        TestBoard.selectWormHoleEntrances();
        TestBoard.selectWormHoleEntrances();
        TestBoard.convertSquareTypes();

        for (Square s: TestBoard.getWormHoleEntranceSquares()){
            assertEquals(s.getSquareType(), SquareType.WORMHOLEENTRANCE);
        }

    }

    @Test
    public void CheckWormHoleExitsConvertedToTypeExits() throws Exception {
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();
        TestBoard.selectWormHoleEntrances();
        TestBoard.selectWormHoleEntrances();
        TestBoard.convertSquareTypes();

        for (Square s: TestBoard.getWormHoleExitSquares()){
            assertEquals(s.getSquareType(), SquareType.WORMHOLEEXIT);
        }

    }

    @ParameterizedTest
    @ValueSource(ints ={1,100,105,108,112,130})
    public void CheckSquares1And100OnwardsAreSetToNormal(int input) throws Exception {

        int testRepeats = 100;

        for (int count = 0; count < testRepeats; count++) {
            Board TestBoard = new Board(10);
            TestBoard.generateBoard();
            TestBoard.selectWormHoleEntrances();
            TestBoard.selectWormHoleEntrances();
            TestBoard.convertSquareTypes();

            Enum<SquareType> SquarePosition = TestBoard.getSquareType(input);
            assertEquals(SquarePosition, SquareType.NORMAL);

          // System.out.println(TestBoard.getBoardSize());//Used for testing bug
         // System.out.println(count);
        }
    }


}


