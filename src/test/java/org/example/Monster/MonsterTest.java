package org.example.Monster;

import org.example.characters.Player;
import org.example.Race;
import org.example.world.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
public class MonsterTest {

    private static final int CORRECT_LEVEL_VALUE = 10;
    private static final int TO_LOW_LEVEL_VALUE = -1;


    @Test
    void playerLossesFightPrintsCorrectMessage() {
        Monster troll = new Troll(100);
        Player player = new Player("player", Race.HUMAN, 10);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        troll.setPrintStream(out);
        troll.battleWithPlayer(player);

        String correctOutput = "You died, Game over";
        assertEquals(correctOutput, output.toString().trim());
    }

    @Test
    void playerWinsFightPrintsCorrectMessage() {
        Monster troll = new Troll(1);
        Player player = new Player("player", Race.HUMAN, 100);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        troll.setPrintStream(out);
        troll.battleWithPlayer(player);

        String correctOutput = "You won the fight!!";
        assertEquals(correctOutput, output.toString().trim());
    }

    @Test
    void InteractionWithMonsterRemovesItFromMap(){
        Tile tile = tileAfterBattle();
        assertFalse(tile.getEntity() instanceof Monster m);
    }


    @Test
    void seamonsterCanBePlacedOnWater(){
        Tile tile = new Tile(new Water());
        Seamonster s = new Seamonster(10);
        tile.setEntity(s);

        assertEquals(tile.getEntity(), s);
    }


    private Tile tileAfterBattle(){
        Monster troll = new Troll(1);
        Player player = new Player("player", Race.HUMAN, 100);
        Tile tile = new Tile(new Floor(), troll);
        player.interactWithTile(tile);

        return tile;
    }




}