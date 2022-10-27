package org.roguelike.monster;

import javafx.scene.paint.Color;
import org.roguelike.characters.Player;
import org.roguelike.characters.Race;
import org.roguelike.gear.Helmet;
import org.roguelike.gear.Ring;
import org.roguelike.gear.Shield;
import org.roguelike.world.PrintFormatConstants;
import org.roguelike.world.Tile;
import org.roguelike.world.Water;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrollTest {

    private static final int CORRECT_LEVEL_VALUE = 10;
    private static final int TO_LOW_LEVEL_VALUE = -1;

    @Test
    void calculateHealthReturnsCorrectValue() {
        Troll troll = new Troll(CORRECT_LEVEL_VALUE);
        int expected = 60;
        assertEquals(expected, troll.getHealth());
    }

    @Test
    void AttackDamageIsGivenCorrectValue() {
        Troll troll = new Troll(CORRECT_LEVEL_VALUE);
        int expected = 430;
        assertEquals(expected, troll.attackDamage());
    }

    @Test
    void trollCanNotBePlacedOnWater() {
        Tile tile = new Tile(new Water());
        Troll troll = new Troll(10);
        tile.setEntity(troll);
        assertNull(tile.getEntity());
    }

    @Test
    void trollUnEquipesPayersShieldPlayerHasShield() {
        Player player = new Player("name", Race.HUMAN, 100);
        Troll troll = new Troll(1);

        Shield s1 = new Shield("shield", "weak", 1, 5);
        Ring ring = new Ring("Ring", "Strong", 8, 8);

        player.addToInventory(s1);
        player.addToInventory(ring);
        player.equip(s1);
        player.equip(ring);

        assertTrue(player.getEquipment().contains(s1));

        troll.battleWithPlayer(player);

        assertFalse(player.getEquipment().contains(s1));

    }

    @Test
    void trollDoesNotUnEquipPayersEquipablesWhenPlayerHasNoShield() {
        Player player = new Player("name", Race.HUMAN, 100);
        Troll troll = new Troll(1);

        Ring ring = new Ring("Ring", "Strong", 8, 8);
        Helmet helmet = new Helmet("Helmet", "Weak", 4, 10);

        player.addToInventory(ring);
        player.addToInventory(helmet);
        player.equip(ring);
        player.equip(helmet);

        troll.battleWithPlayer(player);
        assertTrue(player.getEquipment().contains(ring) && player.getEquipment().contains(helmet));

    }

    @Test
    void tooStringHasCorrectReturnValue() {
        Troll troll = new Troll(CORRECT_LEVEL_VALUE);
        String expected = PrintFormatConstants.BOLD + PrintFormatConstants.RED + "T" + PrintFormatConstants.RESET;
        assertEquals(expected, troll.toString());
    }

    @Test
    void getTextHasCorrectStringApperance() {
        Troll troll = new Troll(CORRECT_LEVEL_VALUE);
        String expected = "T";
        assertEquals(expected, troll.getText().getText());
    }

    @Test
    void getTextHasCorrectColorApperance() {
        Troll troll = new Troll(CORRECT_LEVEL_VALUE);
        Color color = Color.RED;
        assertEquals(color, troll.getText().getFill());
    }

    @Test
    void hasDefaultBaseDmg() {
        Troll troll = new Troll(CORRECT_LEVEL_VALUE);
        assertEquals(0, troll.getBaseDmg().getPhysDmg());
        assertEquals(0, troll.getBaseDmg().getMagicDmg());

    }

}
