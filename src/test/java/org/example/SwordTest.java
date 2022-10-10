package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SwordTest {
    private static final Sword DEFAULT_VALID_SWORD = new Sword("", "", 4, 100);

    @Test
    public void creatingValidSwordGivesNoError() {

        assertEquals(100, DEFAULT_VALID_SWORD.getPhysDmg());
    }

    @Test
    public void creatingTooStrongSwordThrowsException(){
        assertThrows(IllegalAttackDmgException.class, () -> new Sword("", "", 4, Integer.MAX_VALUE));
    }

    @Test
    public void swordIsCompatibleWithDagger(){
        Dagger d = new Dagger("", "", 12, 123);
        assertTrue(DEFAULT_VALID_SWORD.isCompatibleWith(d));
    }

    @Test
    public void swordIsCompatibleWithShield(){
        Shield s = new Shield("", "", 12, 123);
        assertTrue(DEFAULT_VALID_SWORD.isCompatibleWith(s));
    }

    @Test
    public void swordIsIncompatibleWithQuiver(){
        Quiver q = new Quiver("", "", 12, 123);
        assertFalse(DEFAULT_VALID_SWORD.isCompatibleWith(q));
    }

    @Test
    public void  swordIsIncompatibleWithTome() {
        Tome t = new Tome("", "", 12, 123);
        assertFalse(DEFAULT_VALID_SWORD.isCompatibleWith(t));
    }
}