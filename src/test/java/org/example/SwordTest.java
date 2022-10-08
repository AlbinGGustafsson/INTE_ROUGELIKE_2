package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SwordTest {

    @Test
    public void creatingValidSwordGivesNoError() {
        Sword s = new Sword("", "", 4, 100);
        assertEquals(100, s.getAttackDmg());
    }

    @Test
    public void creatingTooStrongSwordThrowsException(){
        assertThrows(IllegalAttackDmgException.class, () -> new Sword("", "", 4, Integer.MAX_VALUE));
    }
}