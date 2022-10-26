package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaggerTest {
    private static final Dagger DEFUALT_VALID_DAGGER =  new Dagger("", "", 4, 42);

    @Test
    void creatingValidDaggerThrowsNoException() {

        assertEquals(42, DEFUALT_VALID_DAGGER.rating);
    }

    @Test
    void creatingTooStrongDaggerThrowsException() {
        assertThrows(IllegalAttackDmgException.class, ()-> new Dagger("", "", 4, 65423215));
    }

    @Test
    public void daggerIsCompatibleWithSword(){
        Sword s = new Sword("", "", 12, 456);
        assertTrue(DEFUALT_VALID_DAGGER.isCompatibleWith(s));
    }

    @Test
    public void daggerIsIncompatibleWithPrimaryWeaponThatIsntSword(){
        Wand w = new Wand("", "", 23, 123);
        Bow b = new Bow("", "", 12, 345);

        assertFalse(DEFUALT_VALID_DAGGER.isCompatibleWith(w));
        assertFalse(DEFUALT_VALID_DAGGER.isCompatibleWith(b));
    }

    @Test
    void physDmgIsEqualToRating(){
        assertEquals(DEFUALT_VALID_DAGGER.rating, DEFUALT_VALID_DAGGER.getPhysDmg());
    }
}