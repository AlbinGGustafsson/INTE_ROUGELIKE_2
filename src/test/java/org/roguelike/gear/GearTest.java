package org.roguelike.gear;

import org.roguelike.characters.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GearTest {

    @Test
    void comparingGearPieaceToNoneGearpieceReturnsMinusOne() {
        Equipable s = new Equipable() {
            @Override
            public boolean canBeEquippedBy(Player player) {
                return false;
            }

            @Override
            public boolean isCompatibleWith(Equipable equipable) {
                return false;
            }

            @Override
            public int maxNumberOfSameTypeEquips() {
                return 0;
            }

            @Override
            public int compareTo(Equipable o) {
                return 0;
            }
        };
        Helmet h = new Helmet("", "", 12, 123);
        assertEquals(-1, h.compareTo(s));
    }

    @Test
    void comparingToItemWithSameIlvlAndRatingReturnsMinusOne(){
        Helmet h = new Helmet("", "", 12, 123);
        Chestpiece c = new Chestpiece("", "", 12, 123);
        assertEquals(-1, h.compareTo(c));
    }
}