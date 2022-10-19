package org.example.Monster;

import org.example.characters.Player;
import org.example.Race;
import org.example.world.Tile;
import org.example.world.Water;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoombaTest {

    @Test
    void calculateHealthGivesCorrectValue(){

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
        Goomba g = new Goomba(10);
        tile.setEntity(g);

        assertEquals(tile.getEntity(), g);
    }
    @Test
    void GoombaWithHigherLevelThanPLayerGivesMoreAttackDamage(){
        Player p = new Player("Name", Race.HUMAN, 1);
        Goomba g = new Goomba(2);
        double expected = 90;
        assertEquals(expected, g.attackDamage());
    }

    @Test
    void goombaWithSameLevelAsPlayerDoesNotGiveMore(){
        Player p = new Player("Name", Race.HUMAN, 2);
        Goomba g = new Goomba(2);
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
}