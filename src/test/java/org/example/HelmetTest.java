package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelmetTest {
    @Test
    public void creatingValidHelmetGivesNoError(){
        Helmet h = new Helmet("","",4,100);
        assertEquals(100, h.getArmorRating());
    }

    @Test
    public void creatingTooStrongHelmetThrowsException(){

        assertThrows(IllegalArmorRatingException.class, () -> {new Helmet("","",4, Integer.MAX_VALUE);});
    }

    @Test
    public void creatingTooLowilvlThrowsException(){
        assertThrows(IllegalItemLevelException.class, () -> {new Helmet("","",0, 100);});
    }

    @Test
    public void creatingNullNameThrowsException(){
        assertThrows(NullPointerException.class, () -> {new Helmet(null, "", 4, 100);});
    }

}