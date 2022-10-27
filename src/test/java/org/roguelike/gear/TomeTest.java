package org.roguelike.gear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TomeTest {
    private static final Tome DEFAULT_VALID_TOME = new Tome("", "", 4, 100);

    @Test
    void creatingTooStrongTomeThrowsException() {
        assertThrows(IllegalSpellDmgException.class, () -> new Tome("", "", 4, 654654654));
    }

    @Test
    void creatingValidTomeGivesNoError() {

        assertEquals(100, DEFAULT_VALID_TOME.rating);
    }

    @Test
    public void tomeIsCompatibleWithWand() {
        Wand w = new Wand("", "", 12, 123);
        assertTrue(DEFAULT_VALID_TOME.isCompatibleWith(w));
    }

    @Test
    public void tomeIsIncompatibleWithEverythingExceptWand() {
        Sword s = new Sword("", "", 12, 123);
        Bow b = new Bow("", "", 12, 123);
        assertFalse(DEFAULT_VALID_TOME.isCompatibleWith(s));
        assertFalse(DEFAULT_VALID_TOME.isCompatibleWith(b));
    }
    @Test
    void magicDmgIsEqualToRating(){
        assertEquals(DEFAULT_VALID_TOME.rating, DEFAULT_VALID_TOME.getMagicDmg());
    }
}