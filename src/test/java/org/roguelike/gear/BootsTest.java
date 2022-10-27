package org.roguelike.gear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BootsTest {

    @Test
    public void creatingValidBootsGivesNoError() {
        Boots b = new Boots("", "", 4, 100);
        assertEquals(100, b.getArmorRating());
    }
}