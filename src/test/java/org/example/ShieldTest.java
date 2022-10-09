package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShieldTest {
    private static final Shield DEFAULT_VALID_SHIELD = new Shield("", "", 4, 46);

    @Test
    void creatingTooStrongShieldThrowsException() {
        assertThrows(IllegalArmorRatingException.class, () -> new Shield("", "", 4, 100000000));
    }

    @Test
    void creatingValidShieldGivesNoError() {

        assertEquals(46, DEFAULT_VALID_SHIELD.rating);
    }

    @Test
    void shieldIsIncompatibleWithBow(){
        Bow b = new Bow("", "", 12, 123);
        assertFalse(DEFAULT_VALID_SHIELD.isCompatibleWith(b));
    }

    @Test
    public void shieldIsCompatibleWithEverythingExceptBow(){
        Sword s = new Sword("", "", 12, 123);
        Wand w = new Wand("", "", 12, 123);
        assertTrue(DEFAULT_VALID_SHIELD.isCompatibleWith(s));
        assertTrue(DEFAULT_VALID_SHIELD.isCompatibleWith(w));
    }
}