package org.example.world;

import javafx.scene.text.Text;
import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TileTest {

    @Test
    void only_Terrain_As_Parameter_Sets_Terrain(){
        Floor floor = new Floor();
        Tile tile = new Tile(floor);
        assertEquals(floor, tile.getTerrain());
    }
    @Test
    void terrain_And_Entity_As_Parameters_Sets_Both(){
        Floor floor = new Floor();
        Stone stone = new Stone();
        Tile tile = new Tile(floor, stone);
        assertEquals(floor, tile.getTerrain());
        assertEquals(stone, tile.getEntity());
    }

    @Test
    void getItems_Returns_Unmodifiable_List(){
        Tile tile = new Tile(new Floor());
        assertThrows(UnsupportedOperationException.class,() -> tile.getItems().clear());
    }

    @Test
    void addItem_Adds_Item(){
        Tile tile = new Tile(new Floor());
        Item item = new Helmet("name", "desc", 1, 1);
        assertFalse(tile.getItems().contains(item));
        tile.addItem(item);
        assertTrue(tile.getItems().contains(item));
    }

    @Test
    void removeItem_Removes_Item(){
        Tile tile = new Tile(new Floor());
        Item item = new Helmet("name", "desc", 1, 1);
        tile.addItem(item);
        tile.removeItem(item);
        assertFalse(tile.getItems().contains(item));
    }

    @Test
    void removeAllItems_Removes_All_Items(){
        Tile tile = new Tile(new Floor());
        Item helmet = new Helmet("name", "desc", 1, 1);
        Item gloves = new Gloves("name", "desc", 1, 1);
        Item chestPiece = new Chestpiece("name", "desc", 1, 1);
        tile.addItem(gloves);
        tile.addItem(chestPiece);
        tile.addItem(helmet);
        tile.removeAllItems();
        assertEquals(0, tile.getItems().size());
    }

    @Test
    void canSetEntity_Tile_Has_NoEntity_Returns_True(){
        Tile tile = new Tile(new Floor());
        assertTrue(tile.canSetEntity(new Stone()));
    }

    @Test
    void canSetEntity_Terrain_Accessible_For_MovableCharacter_Returns_True(){
        Tile tile = new Tile(new Water());
        Player player = new Player("name", Race.HUMAN);
        player.addTerrain(Water.class);
        assertTrue(tile.canSetEntity(player));
    }

    @Test
    void canSetEntity_Tile_Already_Has_Entity_Returns_False(){
        Tile tile = new Tile(new Floor());
        tile.setEntity(new Wall());
        assertFalse(tile.canSetEntity(new Stone()));
    }

    @Test
    void canSetEntity_Terrain_Not_Accessible_For_MovableCharacter_Returns_False(){
        Tile tile = new Tile(new Water());
        Player player = new Player("name", Race.HUMAN);
        assertFalse(tile.canSetEntity(player));
    }

    //Alla andra lägen är redan kontrollerade med canSEtEntityTester
    //setEntity anropar canSetEntity.
    @Test
    void setEntity_Sets_Entity_If_Can_Set_Entity(){
        Tile tile = new Tile(new Floor());
        Stone stone = new Stone();
        tile.setEntity(stone);
        assertEquals(stone, tile.getEntity());
    }

    @Test
    void getText_Correct_Only_Terrain(){
        Tile tile = new Tile(new Floor());
        assertEquals(tile.getTerrain().getText().getText(), tile.getText().getText());
    }
    @Test
    void getText_Correct_Correct_Entity_With_All(){
        Tile tile = new Tile(new Floor(), new Wall());
        tile.addItem(new Helmet("name", "desc", 1, 1));
        assertEquals(tile.getEntity().getText().getText(), tile.getText().getText());
    }

    @Test
    void getText_Correct_Correct_Item_No_Entity(){
        Tile tile = new Tile(new Floor());
        tile.addItem(new Helmet("name", "desc", 1, 1));
        assertEquals("I", tile.getText().getText());
    }

    @Test
    void toString_Correct_Only_Terrain(){
        Tile tile = new Tile(new Floor());
        assertEquals(tile.getTerrain().toString(), tile.toString());
    }
    @Test
    void toString_Correct_Entity_With_All(){
        Tile tile = new Tile(new Floor(), new Wall());
        tile.addItem(new Helmet("name", "desc", 1, 1));
        assertEquals(tile.getEntity().toString(), tile.toString());
    }

    @Test
    void toString_Correct_Item_No_Entity(){
        Tile tile = new Tile(new Floor());
        tile.addItem(new Helmet("name", "desc", 1, 1));
        assertEquals(tile.getItems().get(0).toString(), tile.toString());
    }

}
