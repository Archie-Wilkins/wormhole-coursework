package com.cm6123.wormhole;

import com.cm6123.wormhole.GameLogic.Board;
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

    //Need to create tests for Exits
    //Need to create test to make sure there is no overlap between
    //Entrances and Exits
    //Need to make tests to check first and ending squares arent coverted
    //Need to make method to convert items into array to relevant SquareType

}
