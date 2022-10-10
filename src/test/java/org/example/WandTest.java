package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WandTest {
    private static final Wand DEFAULT_VALID_WAND = new Wand("", "", 4, 200);

    @Test
    public void creatingValidWandGovesNoError(){
        assertEquals(200, DEFAULT_VALID_WAND.getMagicDmg());
    }

    @Test
    public void creatingTooStrongWandThrowsException(){
        assertThrows(IllegalSpellDmgException.class, () -> new Wand("", "", 4, Integer.MAX_VALUE));
    }

    @Test
    public void creatingNegativeItemLevlWandThrowsException(){
        assertThrows(IllegalItemLevelException.class, () -> new Wand("", "", -1, 123));
    }

    @Test
    public void wandIsCompatibleWithTome(){
        Tome t = new Tome("", "", 12, 123);
        assertTrue(DEFAULT_VALID_WAND.isCompatibleWith(t));
    }

    @Test
    public void wandIsCompatibleWithShield(){
        Shield s = new Shield("", "", 12, 123);
        assertTrue(DEFAULT_VALID_WAND.isCompatibleWith(s));
    }

    @Test
    public void wandIsIncompatibleWithDagger(){
        Dagger d = new Dagger("", "", 12, 123);
        assertFalse(DEFAULT_VALID_WAND.isCompatibleWith(d));
    }

    @Test
    public void wandIsIncompatibleWithQuiver(){
        Quiver q = new Quiver("", "", 12, 123);
        assertFalse(DEFAULT_VALID_WAND.isCompatibleWith(q));
    }
}