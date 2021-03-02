package com.cm6123.wormhole;

import com.cm6123.wormhole.GameLogic.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerChecks {

    @Test
    public void getNameReturnsCorrectPlayerName() throws Exception{


    Player Player1 = new Player("John",1);
    String playerName = Player1.getName();
    assertEquals(playerName, "John");
    }

    @Test
    public void getTurnReturnsCorrectPlayerTurn() throws Exception{


        Player Player1 = new Player("John", 1);
        int PlayerTurn1 = Player1.getTurnPosition();
        assertEquals(PlayerTurn1, 1);


        Player Player2 = new Player("Claire", 2);
        int PlayerTurn2 = Player2.getTurnPosition();
        assertEquals(PlayerTurn2, 2);

        Player Player4 = new Player("Claire", 4);
        int PlayerTurn4 = Player4.getTurnPosition();
        assertEquals(PlayerTurn4, 4);
    }

    @Test
    public void initalBoardPositionForPlayersSetTo1() throws Exception {


        Player Player1 = new Player("John", 1);
        int PlayerBoardPosition1 = Player1.getBoardPosition();
        assertEquals(PlayerBoardPosition1, 1);

        Player Player2 = new Player("Sarah", 2);
        int PlayerBoardPosition2 = Player2.getBoardPosition();
        assertEquals(PlayerBoardPosition2, 1);

        Player Player3 = new Player("Pete",3);
        int PlayerBoardPosition3 = Player3.getBoardPosition();
        assertEquals(PlayerBoardPosition3, 1);
    }


}
