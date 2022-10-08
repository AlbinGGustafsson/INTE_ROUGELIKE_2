package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TomeTest {

    @Test
    void creatingTooStrongTomeThrowsException() {
        assertThrows(IllegalSpellDmgException.class, () -> new Tome("", "", 4, 654654654));
    }

    @Test
    void creatingValidTomeGivesNoError() {
        Tome t = new Tome("", "", 4, 100);
        assertEquals(100, t.rating);
    }
}