package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BeltTest {

    @Test
    public void creatingValidBeltGivesNoErrors() {
        Belt b = new Belt("", "", 4, 4);
        assertEquals(4, b.getPercentDmgIncrease());
    }
}