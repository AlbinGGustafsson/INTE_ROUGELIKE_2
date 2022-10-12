package org.example.world;

import org.example.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    void roomNumber_Sets_Correct(){
        TestableRoomCreator tcr = new TestableRoomCreator();
        Room room = tcr.loadRoom(0);
        assertEquals(0, room.getRoomNumber());
    }

    @Test
    void roomType_Sets_Correct(){
        TestableRoomCreator tcr = new TestableRoomCreator();
        Room room = tcr.loadRoom(0);
        assertEquals("StartRoom", room.getRoomType());
    }

    @Test
    void getNextRoom_No_World_Returns_Null(){
        TestableRoomCreator tcr = new TestableRoomCreator();
        Room room = tcr.loadRoom(0);
        assertNull(room.getNextRoom());
    }

    @Test
    void getPrevRoom_No_World_Returns_Null(){
        TestableRoomCreator tcr = new TestableRoomCreator();
        Room room = tcr.loadRoom(0);
        assertNull(room.getPreviousRoom());
    }

    @Test
    void getNextRoom_Not_Exist_Creates_New_room(){
        World world = new World(new TestableRoomCreator());
        Room nextRoom = world.getRoom(0).getNextRoom();
        assertEquals(Room.class, nextRoom.getClass());
    }

    @Test
    void getNextRoom_Exist_Returns_Room(){
        World world = new World(new TestableRoomCreator());
        world.addRoom();
        Room nextRoom = world.getRoom(0).getNextRoom();
        assertEquals(world.getRoom(1), nextRoom);
    }

    @Test
    void getPrevRoom_Not_Exist_Returns_Null(){
        World world = new World(new TestableRoomCreator());
        Room prevRoom = world.getRoom(0).getPreviousRoom();
        assertNull(prevRoom);
    }

    @Test
    void getPrevRoom_Exist_Returns_Room(){
        World world = new World(new TestableRoomCreator());
        world.addRoom();
        Room prevRoom = world.getRoom(1).getPreviousRoom();
        assertEquals(world.getRoom(0), prevRoom);
    }

    @Test
    void setEntity_On_Available_Tile(){
        World world = new World(new TestableRoomCreator());
        Stone stone = new Stone();
        world.getRoom(0).setEntity(stone, new Position(1,1));
        assertEquals(stone, world.getRoom(0).getTile(new Position(1,1)).getEntity());
    }

    @Test
    void setEntity_On_Non_Available_Tile(){
        World world = new World(new TestableRoomCreator());
        Stone stone = new Stone();
        world.getRoom(0).setEntity(stone, new Position(0,0));
        assertNotEquals(stone, world.getRoom(0).getTile(new Position(0,0)).getEntity());
    }

    @Test
    void removeEntity_Entity_Exists_Removes_Entity(){
        World world = new World(new TestableRoomCreator());
        Stone stone = new Stone();
        world.getRoom(0).setEntity(stone, new Position(1,1));
        world.getRoom(0).removeEntity(stone);
        assertNotEquals(stone, world.getRoom(0).getTile(new Position(1,1)).getEntity());
    }

    @Test
    void removeEntity_Entity_Not_Exists_Does_Not_Throw_exception(){
        World world = new World(new TestableRoomCreator());
        Stone stone = new Stone();
        assertDoesNotThrow(() -> world.getRoom(0).removeEntity(stone));
    }

    @Test
    void moveEntity_Entity_Not_Exists_Does_Nothing(){
        World world = new World(new TestableRoomCreator());
        Stone stone = new Stone();
        world.getRoom(0).moveEntity(stone, new Position(2,1));
        assertFalse(world.getRoom(0).contains(stone));
    }

    @Test
    void moveEntity_to_Non_Available_Tile(){
        World world = new World(new TestableRoomCreator());
        Stone stone = new Stone();
        world.getRoom(0).setEntity(stone, new Position(1,1));
        world.getRoom(0).moveEntity(stone, new Position(1,0));
        assertNotEquals(stone, world.getRoom(0).getTile(new Position(1,0)).getEntity());
    }
    @Test
    void moveEntity_to_Available_Tile(){
        World world = new World(new TestableRoomCreator());
        Stone stone = new Stone();
        world.getRoom(0).setEntity(stone, new Position(1,1));
        world.getRoom(0).moveEntity(stone, new Position(1,2));
        assertEquals(stone, world.getRoom(0).getTile(new Position(1,2)).getEntity());
    }

    @Test
    void getDoor_Exists_Returns_Door(){
        World world = new World(new TestableRoomCreator());
        Door door = world.getRoom(0).getDoor(Direction.RIGHT);
        assertEquals(Door.class, door.getClass());
    }
    @Test
    void getDoor_Not_Exists_Returns_Null(){
        World world = new World(new TestableRoomCreator());
        Door door = world.getRoom(0).getDoor(Direction.LEFT);
        assertNull(door);
    }

    @Test
    void getTile_Position_In_Room(){
        World world = new World(new TestableRoomCreator());
        assertEquals(Tile.class, world.getRoom(0).getTile(new Position(0,0)).getClass());
    }
    @Test
    void getTile_Position_Outside_Of_Room_Returns_null(){
        World world = new World(new TestableRoomCreator());
        assertNull(world.getRoom(0).getTile(new Position(20,20)));
    }


    //containsPlayer
    //contains
    //getRoomList Unmodifiable
    //toString
}
