package org.example;

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
}