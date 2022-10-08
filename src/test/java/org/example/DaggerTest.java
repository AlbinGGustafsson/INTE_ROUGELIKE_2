package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaggerTest {

    @Test
    void creatingValidDaggerThrowsNoException() {
        Dagger d = new Dagger("", "", 4, 42);
        assertEquals(42, d.rating);
    }

    @Test
    void creatingTooStrongDaggerThrowsException() {
        assertThrows(IllegalAttackDmgException.class, ()-> new Dagger("", "", 4, 65423215));
    }
}