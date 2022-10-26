package org.example.Monster;
import org.example.*;
import org.example.characters.Player;
import org.example.world.PrintFormatConstants;
import org.example.world.Tile;
import org.example.world.Water;
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
    void constructorThrowsExceptionWhenGivenValueIsToLow() {
        assertThrows(IllegalArgumentException.class, () -> {
            Troll troll = new Troll(TO_LOW_LEVEL_VALUE);
        });
    }

    @Test
    void trollCanNotBePlacedOnWater(){
        Tile tile = new Tile(new Water());
        Troll troll = new Troll(10);
        tile.setEntity(troll);
        assertNull(tile.getEntity());
    }

    @Test
    void trollUnEquipesPayersShieldPlayerHasShield(){
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
    void trollDoesNotUnEquipesPayersEquipablesWhenPlayerHasNoShield(){
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
    void tooStringHasCorrectReturnValue(){
        Troll troll = new Troll(CORRECT_LEVEL_VALUE);
        String expected = PrintFormatConstants.BOLD + PrintFormatConstants.RED + "T" + PrintFormatConstants.RESET;
        assertEquals(expected, troll.toString());
    }



}
