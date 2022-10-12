package org.example.world;

import org.example.Player;
import org.example.Race;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTest {

    @Test
    void creating_World_Creates_Room(){
        World world = new World(new TestableRoomCreator());
        assertEquals(Room.class, world.getRoom(0).getClass());
    }

    @Test
    void addRoom_creates_Another_Room(){
        World world = new World(new TestableRoomCreator());
        world.addRoom();
        assertEquals(Room.class, world.getRoom(1).getClass());
    }

    @Test
    void spawnPlayer_Spawns_Player(){
        World world = new World(new TestableRoomCreator());
        Player player = new Player("name", Race.HUMAN);
        world.spawnPlayer(player);
        assertEquals(player, world.getRoom(0).getTile(new Position(1,1)).getEntity());
    }

    @Test
    void getRoom_RoomNumber_Not_Exists_Returns_Null(){
        World world = new World(new TestableRoomCreator());
        assertNull(world.getRoom(1));
    }

    @Test
    void toString_Correct_Multiple_Rooms_Without_Player(){
        World world = new World(new TestableRoomCreator());
        world.addRoom();
        world.addRoom();
        world.addRoom();
        world.addRoom();
        String correctToString = "StartRoom NormalRoom BossRoom NormalRoom NormalRoom ";
        assertEquals(correctToString, world.toString());
    }

    @Test
    void toString_Correct_Multiple_Rooms_Player(){
        World world = new World(new TestableRoomCreator());
        world.spawnPlayer(new Player("name", Race.HUMAN));
        world.addRoom();
        world.addRoom();
        world.addRoom();
        world.addRoom();
        String correctToString = String.format("(%sP%s)StartRoom NormalRoom BossRoom NormalRoom NormalRoom ", PrintFormatConstants.PURPLE, PrintFormatConstants.RESET);
        assertEquals(correctToString, world.toString());
    }

}
