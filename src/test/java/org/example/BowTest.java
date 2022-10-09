package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowTest {
    private static final Bow DEFAULT_VALID_BOW = new Bow("", "", 4, 456);

    @Test
    void creatingValidBowGivesNoError() {
        assertEquals(456, DEFAULT_VALID_BOW.rating);
    }

    @Test
    void creatingTooStrongBowThrowsException() {
        assertThrows(IllegalAttackDmgException.class, ()-> new Bow("", "", 4, 654654654));
    }

    @Test
    public void bowIsCompatibleWithQuiver(){
        Quiver q = new Quiver("", "", 12, 123);
        assertTrue(DEFAULT_VALID_BOW.isCompatibleWith(q));
    }

    @Test
    public void bowIsIncompatibleWithEverythingExceptQuiver(){
        Tome t = new Tome("", "", 12, 123);
        Shield s = new Shield("", "", 12, 123);
        Dagger d = new Dagger("", "", 12, 123);

        assertFalse(DEFAULT_VALID_BOW.isCompatibleWith(t));
        assertFalse(DEFAULT_VALID_BOW.isCompatibleWith(s));
        assertFalse(DEFAULT_VALID_BOW.isCompatibleWith(d));
    }
}