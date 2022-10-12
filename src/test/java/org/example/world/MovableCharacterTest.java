package org.example.world;

import org.example.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class MovableCharacterTest {

    private MovableCharacter mc;

    @BeforeEach
    void createMovableCharacterInstance(){
        mc = new MovableCharacter("Albin", Race.HUMAN) {
            {
                terrains.clear();
            }
            @Override
            protected boolean interactWithTile(Tile tile) {
                return false;
            }

            @Override
            public String toString() {
                return "A";
            }
        };
    }

    @Test
    void name_Sets_Correct() {
        assertEquals("Albin", mc.getName());
    }

    @Test
    void race_Sets_Correct(){
        assertEquals(Race.HUMAN, mc.getRace());
    }

    @Test
    void add_Terrain_Adds_Terrain(){
        assertFalse(mc.getTerrains().contains(Water.class));
        mc.addTerrain(Water.class);
        assertTrue(mc.getTerrains().contains(Water.class));
    }

    @Test
    void remove_Terrain_Removes_Terrain(){
        mc.addTerrain(Water.class);
        assertTrue(mc.getTerrains().contains(Water.class));
        mc.removeTerrain(Water.class);
        assertFalse(mc.getTerrains().contains(Water.class));
    }

    @Test
    void terrains_Not_Adding_Duplicates(){
        mc.addTerrain(Water.class);
        var referenceTerrain = mc.getTerrains();
        mc.addTerrain(Water.class);
        assertEquals(referenceTerrain, mc.getTerrains());
    }


    //här används nu filystsemet i testet. vilket inte är bra, ska göras med dependency injection istället.
    @Test
    void move_Moves_MovableCharacter_In_Room(){
        mc.addTerrain(Floor.class);
        World world = new World();
        Position spawnPosition = new Position(1,1);
        world.getRoom(0).setEntity(mc, spawnPosition);
        mc.move(Direction.RIGHT);
        assertEquals(spawnPosition.getPos(Direction.RIGHT), mc.getPosition());
    }


//    @ParameterizedTest(name = "{index} int: {0}")
//    @MethodSource("allDirections")
//    void move_Moves_MovableCharacter_In_Room(Direction direction){
//        World world = new World();
//        Position spawnPosition = new Position(1,1);
//        world.getRoom(0).setEntity(mc, spawnPosition);
//        mc.move(direction);
//        assertEquals(spawnPosition.getPos(direction), mc.getPosition());
//    }

//    private static Stream<Direction> allDirections(){
//        return Arrays.stream(Direction.class.getEnumConstants());
//    }

    //move all directions

    //getTerrains (returnsUnmoidfiable)

    //interactwithTile

}
