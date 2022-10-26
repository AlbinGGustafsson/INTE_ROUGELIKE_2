package org.example;

import org.example.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LevelingPlayerTest {
    private Player player;

    @BeforeEach
    void setUp(){
        player = new Player("name", Race.DWARF);
    }

    @Test
    void levelingUpWorks() {
        player.gainExp(1);
        assertEquals(2, player.getLevel());
    }

    @Test
    void gainingExpWorks() {
        player.gainExp(123);
        assertEquals(123, player.getExp());
    }

    @Test
    void gainingExpCanLevelUpMultipleTimes(){
        player.gainExp(19683);
        assertEquals(10, player.getLevel());
    }

    @Test
    void gainingExpPastMaxLevelIsImpossible(){
        player.gainExp(1000000000);
        assertEquals(955780963, player.getExp());
    }

    @Test
    void levelingPastMaxLevelIsImpossible(){
        player.gainExp(1000000000);
        assertEquals(100, player.getLevel());
    }

    @Test
    void settingLevelInConstructorMakesThePlayerHaveTheRightExp(){
        Player p2 = new Player("name", Race.DWARF, 56);
        assertEquals(67862852, p2.getExp());
    }

    @Test
    void settingAboveMaxLevelInConstructorSetsMaxLevel(){
        Player p2 = new Player("name", Race.DWARF, 101);
        assertEquals(100, p2.getLevel());
    }

    @Test
    void settingBelowLevelOneInConstructorSetsLevelOne(){
        Player p2 = new Player("name", Race.DWARF, -1);
        assertEquals(1, p2.getLevel());
    }
}