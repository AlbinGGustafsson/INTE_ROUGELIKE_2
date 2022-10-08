package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuiverTest {

    @Test
    void creatingValidQuiverGivesNoError() {
        Quiver q = new Quiver("", "", 4, 45);
        assertEquals(45, q.rating);

    }

    @Test
    void creatingTooStrongQuiver() {
        assertThrows(IllegalAttackDmgException.class, ()-> new Quiver("", "", 4, 56465456));
    }
}