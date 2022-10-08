package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowTest {

    @Test
    void creatingValidBowGivesNoError() {
        Bow b = new Bow("", "", 4, 456);
        assertEquals(456, b.rating);
    }

    @Test
    void creatingTooStrongBowThrowsException() {
        assertThrows(IllegalAttackDmgException.class, ()-> new Bow("", "", 4, 654654654));
    }
}