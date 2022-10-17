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
    void calculateHealthReturnsCorrectValue() {
        Troll troll = new Troll(CORRECT_LEVEL_VALUE);
        int expected = 420;
        assertEquals(expected, troll.getHealth());
    }

    @Test
    void AttackDamageIsGivenCorrectValue() {
        Troll troll = new Troll(CORRECT_LEVEL_VALUE);
        int expected = 50;
        assertEquals(expected, troll.attackDamage());
    }

    @Test
    void constructorThrowsExceptionWhenGivenValueIsToLow() {
        assertThrows(IllegalArgumentException.class, () -> {
            Troll troll = new Troll(TO_LOW_LEVEL_VALUE);
        });
    }

    @Test
    void playerLossesFightPrintsCorrectMessage() {
        Troll troll = new Troll(100);
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
        Troll troll = new Troll(1);
        Player player = new Player("player", Race.HUMAN, 10);
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
    void playerMovesWhenBattleIsWon(){
        Tile tile = tileAfterBattle();
        assertTrue(tile.getEntity() instanceof Player p);
    }


    @Test
    void seamonsterCanBePlacedOnWater(){
        Tile tile = new Tile(new Water());
        Seamonster s = new Seamonster(10);
        tile.setEntity(s);

        assertEquals(tile.getEntity(), s);
    }

    @Test
    void trollCanNotBePlacedOnWater(){
        Tile tile = new Tile(new Water());
        Troll troll = new Troll(10);
        tile.setEntity(troll);
        assertNull(tile.getEntity());
    }

    private Tile tileAfterBattle(){
        Troll troll = new Troll(1);
        Player player = new Player("player", Race.HUMAN, 100);
        Tile tile = new Tile(new Floor(), troll);
        player.interactWithTile(tile);

        return tile;
    }




}