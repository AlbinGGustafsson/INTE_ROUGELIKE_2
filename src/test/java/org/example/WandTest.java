package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WandTest {
    @Test
    public void creatingValidWandGovesNoError(){
        Wand w = new Wand("", "", 4, 200);
        assertEquals(200, w.getSpellDmg());
    }

    @Test
    public void creatingTooStrongWandThrowsException(){
        assertThrows(IllegalSpellDmgException.class, () -> new Wand("", "", 4, Integer.MAX_VALUE));
    }

    @Test
    public void creatingNegativeItemLevlWandThrowsException(){
        assertThrows(IllegalItemLevelException.class, () -> new Wand("", "", -1, 123));
    }
}