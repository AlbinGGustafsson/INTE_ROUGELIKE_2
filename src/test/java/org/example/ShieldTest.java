package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShieldTest {

    @Test
    void creatingTooStrongShieldThrowsException() {
        assertThrows(IllegalArmorRatingException.class, () -> new Shield("", "", 4, 100000000));
    }

    @Test
    void creatingValidShieldGivesNoError() {
        Shield s = new Shield("", "", 4, 46);
        assertEquals(46, s.rating);
    }
}