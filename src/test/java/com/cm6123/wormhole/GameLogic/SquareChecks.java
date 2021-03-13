package com.cm6123.wormhole.GameLogic;

import com.cm6123.wormhole.GameLogic.Square;
import com.cm6123.wormhole.GameLogic.SquareType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareChecks {
    @Test
    public void SetSquaresToWormHoleEntranceFromNormal() throws Exception{
        Square testSquare = new Square(4,SquareType.NORMAL);
        testSquare.setSquareType(SquareType.WORMHOLEENTRANCE);
        assertEquals(testSquare.getSquareType(), SquareType.WORMHOLEENTRANCE);
    }

    @Test
    public void SetSquaresToWormHoleExitFromNormal() throws Exception{
        Square testSquare = new Square(4,SquareType.NORMAL);
        testSquare.setSquareType(SquareType.WORMHOLEEXIT);
        assertEquals(testSquare.getSquareType(), SquareType.WORMHOLEEXIT);
    }

}
