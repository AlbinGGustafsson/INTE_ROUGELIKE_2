package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NecklaceTest {

    @Test
    public void creatingValidNecklaceGivesNoError() {
        Necklace n = new Necklace("", "", 4, 16);
        assertEquals(16, n.getPercentDmgIncrease());
    }
}