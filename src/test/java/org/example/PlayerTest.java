package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private static final Player PLAYER = new Player("", Race.DWARF);

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
}