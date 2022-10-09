package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuiverTest {

    @Test
    void creatingValidQuiverGivesNoError() {
        Quiver q = new Quiver("", "", 4, 45);
        assertEquals(45, q.rating);

    }

    @Test
    void creatingTooStrongQuiver() {
        assertThrows(IllegalAttackDmgException.class, ()-> new Quiver("", "", 4, 56465456));
    }

    @Test
    public void checkingCompatibiltyWithAnyPrimaryWeaponExceptBowReturnsFalse(){
        Quiver q = new Quiver("", "", 4, 78);
        Sword s = new Sword("", "", 4, 45);
        Wand w = new Wand("", "", 4, 132);
        assertFalse(q.isCompatibleWith(s));
        assertFalse(q.isCompatibleWith(w));
    }

    @Test
    public void checkingCompatibilityWithBowReturnsTrue(){
        Quiver q = new Quiver("", "", 4, 78);
        Bow b = new Bow("", "", 5, 123);
        assertTrue(q.isCompatibleWith(b));
    }
}