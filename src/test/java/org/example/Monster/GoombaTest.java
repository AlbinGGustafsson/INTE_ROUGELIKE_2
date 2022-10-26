package org.example.Monster;

import org.example.characters.Player;
import org.example.Race;
import org.example.world.PrintFormatConstants;
import org.example.world.Tile;
import org.example.world.Water;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoombaTest {

    private static final int CORRECT_GOOMBA_LEVEL = 5;

    @Test
    void calculateHealthGivesCorrectValue(){
        Goomba g = new Goomba(CORRECT_GOOMBA_LEVEL);
        double expected = 62.5;
        assertEquals(expected, g.getHealth());
    }

    @Test
    void attackDamageGivesCorrectValue(){
        Goomba g = new Goomba(3);
        double expected = 60;
        assertEquals(expected, g.attackDamage());
    }

    @Test
    void goombaCanBePlacedOnWater(){
        Tile tile = new Tile(new Water());
        Goomba g = new Goomba(CORRECT_GOOMBA_LEVEL);
        tile.setEntity(g);

        assertEquals(tile.getEntity(), g);
    }
    @Test
    void HigherLevelThanPLayerAddsGoombaDamage(){
        Player p = new Player("Name", Race.HUMAN, 1);
        Goomba g = new Goomba(2);
        g.battleWithPlayer(p);
        double expected = 60;
        assertEquals(expected, g.attackDamage());
    }

    @Test
    void goombaWithSameLevelAsPlayerDoesNotGiveMore(){
        Player p = new Player("Name", Race.HUMAN, 2);
        Goomba g = new Goomba(2);
        g.battleWithPlayer(p);
        double expected = 40;
        assertEquals(expected, g.attackDamage());
    }

    @Test
    void goombaWithlowerLevelAsPlayerDoesNotGiveMore(){
        Player p = new Player("Name", Race.HUMAN, 2);
        Goomba g = new Goomba(1);
        double expected = 20;
        assertEquals(expected, g.attackDamage());
    }

    @Test
    void tooStringHasCorrectReturnValue(){
        Goomba g = new Goomba(CORRECT_GOOMBA_LEVEL);
        String expected = PrintFormatConstants.BOLD + PrintFormatConstants.RED + "G" + PrintFormatConstants.RESET;
        assertEquals(expected, g.toString());
    }
//
//    @Test
//    void battleWithPLayerGivesCorrectExp(){
//        Player player = new Player("namn", Race.HUMAN);
//        Goomba gomba
//    }
}