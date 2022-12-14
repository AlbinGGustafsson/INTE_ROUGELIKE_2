package org.roguelike.gear;

import org.roguelike.characters.Race;
import org.roguelike.characters.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipableTest {

    @Test
    void playerCanEquipValidItem() {
        Player p = new Player("name", Race.DWARF, 10);
        Helmet h = new Helmet("", "", 4, 100);

        assertTrue(h.canBeEquippedBy(p));
    }

    @Test
    public void playerCantEquipInvalidItem(){
        Player p = new Player("name", Race.DWARF, 10);
        Helmet h = new Helmet("", "", 40, 100);

        assertFalse(h.canBeEquippedBy(p));
    }


}