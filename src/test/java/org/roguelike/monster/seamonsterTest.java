package org.roguelike.monster;
import javafx.scene.paint.Color;
import org.roguelike.characters.Race;
import org.roguelike.characters.Player;
import org.roguelike.world.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class seamonsterTest {

    private static final int CORRECT_LEVEL_VALUE = 10;
    private final Seamonster seamonster = new Seamonster(CORRECT_LEVEL_VALUE);

    @Test
    void calculateHealthGivesCorrectValue(){
        int expected = 80;
        assertEquals(expected, seamonster.calculateHealth());
    }


    @Test
    void seamonsterCanBePlacedOnWater(){
        Tile tile = new Tile(new Water());
        tile.setEntity(seamonster);
        assertEquals(tile.getEntity(), seamonster);
    }

    @Test
    void attackDamageGivesCorrectValue(){
        double expected = 34.5;
        assertEquals(expected, seamonster.attackDamage());
    }

    @Test
    void seamonstersTileBecomesWaterWhenDie(){
        World world = new World();
        Player player = new Player("Name",  Race.HUMAN, 8);
        Seamonster s = new Seamonster(CORRECT_LEVEL_VALUE);
        world.getRoom(0).setEntity(s, new Position(5, 2));

        s.battleWithPlayer(player);

       assertTrue(world.getRoom(0).getTile(new Position(5,2)).getTerrain() instanceof Water);

    }

    @Test
    void tileTerrainDoesNotChange(){
        World world = new World();
        Player player = new Player("Name",  Race.HUMAN, 11);

        world.getRoom(0).setEntity(seamonster, new Position(5, 2));

        seamonster.battleWithPlayer(player);

        assertFalse(world.getRoom(0).getTile(new Position(5,2)).getTerrain() instanceof Water);
    }

    @Test
    void battleSeamonsterWithHigherLevelGrantsSwim(){
        World world = new World();
        Player player = new Player("Name",  Race.HUMAN, 8);
        world.getRoom(0).setEntity(seamonster, new Position(5, 2));
        assertFalse(player.getTerrains().contains(Water.class));
        seamonster.battleWithPlayer(player);


        assertTrue(player.getTerrains().contains(Water.class));

    }

    @Test
    void battleSeamonsterWithLowerLevelDoesNotGrantSwim(){
        World world = new World();
        Player player = new Player("Name",  Race.HUMAN, 11);
        world.getRoom(0).setEntity(seamonster, new Position(5, 2));
        seamonster.battleWithPlayer(player);


        assertFalse(player.getTerrains().contains(Water.class));
    }


    @Test
    void correctToStringValue(){
        String expected = PrintFormatConstants.BOLD + PrintFormatConstants.RED + "S" + PrintFormatConstants.RESET;
        assertEquals(expected, seamonster.toString());
    }
    @Test
    void getTextHasCorrectStringApperance(){
        Seamonster seamonster = new Seamonster(CORRECT_LEVEL_VALUE);
        String expected = "S";
        assertEquals(expected, seamonster.getText().getText());
    }

    @Test
    void getTextHasCorrectColorApperance(){
        Seamonster seamonster = new Seamonster(CORRECT_LEVEL_VALUE);
        Color color = Color.RED;
        assertEquals(color,  seamonster.getText().getFill());
    }
}
