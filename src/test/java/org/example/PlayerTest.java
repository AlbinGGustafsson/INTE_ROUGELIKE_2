package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player PLAYER;

    @BeforeEach
    public void setUp(){
        PLAYER = new Player("", Race.DWARF, 5);
    }

    @Test
    void equippingUnequibleGearDoesntWork() {
        Helmet h = new Helmet("", "", 12, 123);
        assertThrows(CannotEquipException.class, ()-> PLAYER.equip(h));

    }

    @Test
    public void addingItemsToInventoryWorks(){
        Helmet h = new Helmet("", "", 12, 123);
        PLAYER.addToInventory(h);
        assertTrue(PLAYER.getInventory().contains(h));
    }
    @Test
    public void equippingWorks(){
        Helmet h = new Helmet("", "", 1, 123);
        PLAYER.addToInventory(h);
        PLAYER.equip(h);
        assertTrue(PLAYER.getEquipment().contains(h));
    }
    @Test
    public void unequippingWorks(){
        Helmet h = new Helmet("", "", 1, 123);
        PLAYER.addToInventory(h);
        PLAYER.equip(h);
        PLAYER.unequip(h);
        assertFalse(PLAYER.getEquipment().contains(h));
    }

    @Test
    public void rightDmgIsTaken(){
        Chestpiece c = new Chestpiece("", "", 4, 400);
        Helmet h = new Helmet("", "", 1, 123);
        PLAYER.addToInventory(c);
        PLAYER.addToInventory(h);
        PLAYER.equip(c);
        PLAYER.equip(h);
        int hp = PLAYER.getHealthPoints();
        PLAYER.takeDmg(1000);
        assertEquals(hp - 200, PLAYER.getHealthPoints());
    }
}