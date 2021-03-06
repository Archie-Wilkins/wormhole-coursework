package com.cm6123.wormhole;

import com.cm6123.wormhole.GameLogic.Board;
import com.cm6123.wormhole.GameLogic.Square;
import com.cm6123.wormhole.GameLogic.SquareType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardChecks {

    @Test
    public void BoardGeneratesSquaresWithCorrectPositions() throws Exception {
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();

        int SquarePosition1 = TestBoard.getSquarePosition(1);
        assertEquals(SquarePosition1, 1);

        int SquarePosition64 = TestBoard.getSquarePosition(64);
        assertEquals(SquarePosition64, 64);

        int SquarePosition99 = TestBoard.getSquarePosition(99);
        assertEquals(SquarePosition99, 99);

        int SquarePosition100 = TestBoard.getSquarePosition(100);
        assertEquals(SquarePosition100, 100);

        int SquarePosition112 = TestBoard.getSquarePosition(112);
        assertEquals(SquarePosition112, 112);
    }

    @Test
    public void BoardGeneratesSquaresWithEnumOfNormal() throws Exception {
        Board TestBoard = new Board(10);
        TestBoard.generateBoard();

        assertEquals(TestBoard.getSquareType(1), SquareType.NORMAL);

        assertEquals(TestBoard.getSquareType(64), SquareType.NORMAL);

        assertEquals(TestBoard.getSquareType(99), SquareType.NORMAL);

        assertEquals(TestBoard.getSquareType(100), SquareType.NORMAL);

        assertEquals(TestBoard.getSquareType(112), SquareType.NORMAL);
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

    @Test
    public void CheckSquares1And100OnwardsAreSetToNormal() throws Exception {

        int testRepeats = 100;

        for (int count = 0; count < testRepeats; count++) {
            Board TestBoard = new Board(10);
            TestBoard.generateBoard();
            TestBoard.selectWormHoleEntrances();
            TestBoard.selectWormHoleEntrances();
            TestBoard.convertSquareTypes();

            Enum<SquareType> Position1 = TestBoard.getSquareType(1);
            assertEquals(Position1, SquareType.NORMAL);


            Enum<SquareType> Position100 = TestBoard.getSquareType(100);
            assertEquals(Position100, SquareType.NORMAL);


            Enum<SquareType> Position105 = TestBoard.getSquareType(105);
            assertEquals(Position105, SquareType.NORMAL);

            Enum<SquareType> Position108 = TestBoard.getSquareType(108);
            assertEquals(Position108, SquareType.NORMAL);

            Enum<SquareType> Position112 = TestBoard.getSquareType(112);
            assertEquals(Position112, SquareType.NORMAL);
            System.out.println(TestBoard.getBoardSize());
            System.out.println(count);
        }
    }


}


