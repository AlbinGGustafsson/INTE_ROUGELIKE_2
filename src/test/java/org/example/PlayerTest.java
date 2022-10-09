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
}