package org.roguelike.gear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RingTest {

    @Test
    public void creatingValidRingGivesNoErrors(){
        Ring r = new Ring("", "", 4, 4);
        assertEquals(4, r.getPercentDmgIncrease());
    }

    @Test
    public void creatingTooStrongRingThrowsException(){
        assertThrows(IllegalPercentDmgIncreaseException.class, () -> new Ring("", "", 4, Integer.MAX_VALUE));
    }

    @Test public void creatingTooHighilvlRingThrowsException(){
        assertThrows(IllegalItemLevelException.class, () -> new Ring("", "", Integer.MAX_VALUE, 6));
    }

}