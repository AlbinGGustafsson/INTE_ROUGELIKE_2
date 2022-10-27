package org.roguelike.gear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GlovesTest {

    @Test
    public void creatingValidGlovesGivesNoError() {
        Gloves g = new Gloves("", "", 4, 100);
        assertEquals(100, g.getArmorRating());
    }
}