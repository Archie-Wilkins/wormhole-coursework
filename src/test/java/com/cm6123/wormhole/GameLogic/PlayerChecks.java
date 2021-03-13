package com.cm6123.wormhole.GameLogic;

import com.cm6123.wormhole.GameLogic.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerChecks {

    @Test
    public void getNameReturnsCorrectPlayerName() throws Exception{


    Player Player1 = new Player("John",false);
    String playerName = Player1.getName();
    assertEquals(playerName, "John");
    }

    @Test
    public void initalBoardPositionForPlayersSetTo1() throws Exception {


        Player Player1 = new Player("John",  false);
        int PlayerBoardPosition1 = Player1.getBoardPosition();
        assertEquals(PlayerBoardPosition1, 1);

        Player Player2 = new Player("Sarah",  false);
        int PlayerBoardPosition2 = Player2.getBoardPosition();
        assertEquals(PlayerBoardPosition2, 1);

        Player Player3 = new Player("Pete", false);
        int PlayerBoardPosition3 = Player3.getBoardPosition();
        assertEquals(PlayerBoardPosition3, 1);
    }

    @Test
    public void testSettingPlayerNewPosition() throws Exception {
        Player Player1 = new Player("John",  false);
        Player1.setBoardPosition(5);
        assertEquals(Player1.getBoardPosition(), 5);
    }


}
