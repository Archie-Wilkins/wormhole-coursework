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


}
