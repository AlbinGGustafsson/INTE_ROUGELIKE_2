package org.roguelike.gear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChestpieceTest {

    @Test
    public void creatingValidChestpieceGivesNoErrors() {
        Chestpiece c = new Chestpiece("", "", 1, 100);
        assertEquals(100, c.getArmorRating());
    }

    @Test
    public void creatingTooStrongChespieceThrowsException(){
        assertThrows(IllegalArmorRatingException.class, () -> new Chestpiece("", "", 1, Integer.MAX_VALUE));
    }

    @Test
    void isCompatibleWithHelmet(){
        Helmet h = new Helmet("", "", 10, 100);
        Chestpiece c = new Chestpiece("", "", 1, 100);
        assertTrue(c.isCompatibleWith(h));
    }
}