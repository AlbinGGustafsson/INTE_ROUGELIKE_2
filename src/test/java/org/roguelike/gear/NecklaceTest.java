package org.roguelike.gear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NecklaceTest {

    @Test
    public void creatingValidNecklaceGivesNoError() {
        Necklace n = new Necklace("", "", 4, 16);
        assertEquals(16, n.getPercentDmgIncrease());
    }
    @Test
    void necklaceIsCompatibleWithEarring(){

        Necklace n = new Necklace("", "", 4, 16);
        Earring earring = new Earring("", "", 4, 5);

        assertTrue(n.isCompatibleWith(earring));
    }

}