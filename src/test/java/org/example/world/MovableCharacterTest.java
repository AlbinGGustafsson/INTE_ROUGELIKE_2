package org.example.world;

import org.example.Helmet;
import org.example.Item;
import org.example.Player;
import org.example.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

                if (!tile.getItems().isEmpty()){
                    getPrintStream().print("You found " + tile.getItems().get(0).getName());
                }

                if (tile.getEntity() instanceof Wall){
                    getPrintStream().print("There is a wall in the way");
                }

                if (tile.getTerrain() instanceof Water w && !getTerrains().contains(Water.class)){
                    w.printNonReachableMessage();
                    //getPrintStream().print("You cant swim");
                }
                return false;
            }

            @Override
            public String toString() {
                return "M";
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

    @ParameterizedTest
    @MethodSource("allDirections")
    void move_Moves_MovableCharacter_In_Room_On_Accepted_Terrain_All_Directions(Direction direction){
        mc.addTerrain(Floor.class);

        TestableRoomCreator trc = new TestableRoomCreator();
        Room room = trc.loadRoom(0);
        Position spawnPosition = new Position(2,2);
        room.setEntity(mc, spawnPosition);
        mc.move(direction);
        assertEquals(spawnPosition.getPos(direction), mc.getPosition());
    }

    private static Stream<Direction> allDirections(){
        return Arrays.stream(Direction.class.getEnumConstants());
    }


    @Test
    void move_Not_Moves_MovableCharacter_In_Room_On_Not_Accepted_Terrain(){
        mc.addTerrain(Floor.class);

        TestableRoomCreator trc = new TestableRoomCreator();
        Room room = trc.loadRoom(0);
        Position spawnPosition = new Position(3,1);
        room.setEntity(mc, spawnPosition);
        mc.move(Direction.RIGHT);
        assertEquals(spawnPosition, mc.getPosition());
    }

    @Test
    void move_Not_Moves_MovableCharacter_In_Room_When_Entity_Is_In_The_Way(){
        mc.addTerrain(Floor.class);

        TestableRoomCreator trc = new TestableRoomCreator();
        Room room = trc.loadRoom(0);
        Position spawnPosition = new Position(1,1);
        room.setEntity(mc, spawnPosition);
        room.setEntity(new Stone(), new Position(2, 1));
        mc.move(Direction.RIGHT);
        assertEquals(spawnPosition, mc.getPosition());
    }

    @Test
    void getTerrains_Returns_Unmodifiable_List(){
        assertThrows(UnsupportedOperationException.class,() -> mc.getTerrains().add(Floor.class));
    }


    @Test
    void movableCharacter_Interaction_Entity(){
        mc.addTerrain(Floor.class);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        mc.setPrintStream(out);

        TestableRoomCreator trc = new TestableRoomCreator();
        Room room = trc.loadRoom(0);
        Position spawnPosition = new Position(1,1);
        room.setEntity(mc, spawnPosition);
        room.setEntity(new Wall(), new Position(2, 1));
        mc.move(Direction.RIGHT);

        String correctOutput = "There is a wall in the way";
        assertEquals(correctOutput, output.toString());
    }

    @Test
    void movableCharacter_Interaction_Terrain(){
        mc.addTerrain(Floor.class);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        mc.setPrintStream(out);

        //Terrain och Entity har statisk variabel PrintStream. Ändrar jag det på ett vatten så har alla vatten den streamen.
        //Gjorde inte så på testat ovanför.
        Water water = new Water();
        water.setPrintStream(out);

        TestableRoomCreator trc = new TestableRoomCreator();
        Room room = trc.loadRoom(0);
        Position spawnPosition = new Position(3,1);
        room.setEntity(mc, spawnPosition);
        mc.move(Direction.RIGHT);

        String correctOutput = "You cant swim";
        assertEquals(correctOutput, output.toString().trim());
    }

    @Test
    void movableCharacter_Interaction_Item(){
        mc.addTerrain(Floor.class);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        mc.setPrintStream(out);

        Item item = new Helmet("ItemName", "ItemDesc", 1, 1);
        TestableRoomCreator trc = new TestableRoomCreator();
        Room room = trc.loadRoom(0);
        Position spawnPosition = new Position(1,1);
        room.setEntity(mc, spawnPosition);
        room.getTile(new Position(2,1)).addItem(item);
        mc.move(Direction.RIGHT);

        String correctOutput = "You found ItemName";
        assertEquals(correctOutput, output.toString());
    }

    @Test
    void movableCharacter_Changing_Room_To_The_Left(){
        World world = new World(new TestableRoomCreator());
        Player player = new Player("name", Race.HUMAN);
        world.getRoom(0).setEntity(player, new Position(4,2));
        System.out.println(world.getRoom(0));
        player.move(Direction.RIGHT);
        System.out.println(world.getRoom(1));

        Room newRoom = world.getRoom(1);
        Position newPlayerPosition = newRoom.getDoor(Direction.LEFT).getPosition().getPos(Direction.RIGHT);
        assertEquals(player, newRoom.getTile(newPlayerPosition).getEntity());
        assertFalse(world.getRoom(0).contains(player));
    }

    @Test
    void movableCharacter_Changing_Room_To_The_Right(){
        World world = new World(new TestableRoomCreator());
        world.addRoom();
        Player player = new Player("name", Race.HUMAN);
        world.getRoom(1).setEntity(player, new Position(1,2));
        player.move(Direction.LEFT);

        Room newRoom = world.getRoom(0);
        Position newPlayerPosition = newRoom.getDoor(Direction.RIGHT).getPosition().getPos(Direction.LEFT);
        assertEquals(player, newRoom.getTile(newPlayerPosition).getEntity());
        assertFalse(world.getRoom(1).contains(player));
    }


}
