package org.roguelike.world;

import org.roguelike.characters.Player;
import org.roguelike.characters.Race;
import org.junit.jupiter.api.Test;

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
    void getNextRoom_No_World_Throws_Exception(){
        TestableRoomCreator tcr = new TestableRoomCreator();
        Room room = tcr.loadRoom(0);
        assertThrows(RuntimeException.class, () -> room.getNextRoom());
    }

    @Test
    void getPrevRoom_No_World_Throws_Exception(){
        TestableRoomCreator tcr = new TestableRoomCreator();
        Room room = tcr.loadRoom(0);
        assertThrows(RuntimeException.class, () -> room.getPreviousRoom());
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
    void getPrevRoom_Not_Exist_Throws_Exception(){
        World world = new World(new TestableRoomCreator());
        assertThrows(RuntimeException.class, () -> world.getRoom(0).getPreviousRoom());
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
    void removeEntity_removed_Entity_Has_No_Room(){
        World world = new World(new TestableRoomCreator());
        Stone stone = new Stone();
        world.getRoom(0).setEntity(stone, new Position(1,1));
        world.getRoom(0).removeEntity(stone);
        assertNull(stone.getRoom());
    }

    @Test
    void removeEntity_removed_Entity_Has_No_Position(){
        World world = new World(new TestableRoomCreator());
        Stone stone = new Stone();
        world.getRoom(0).setEntity(stone, new Position(1,1));
        world.getRoom(0).removeEntity(stone);
        assertNull(stone.getPosition());
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

    @Test
    void containsPlayer_Returns_True_If_Room_Contains_Player(){
        World world = new World(new TestableRoomCreator());
        world.spawnPlayer(new Player("name", Race.HUMAN));
        assertTrue(world.getRoom(0).containsPlayer());
    }

    @Test
    void containsPlayer_Returns_False_If_Room_Not_Contains_Player(){
        World world = new World(new TestableRoomCreator());
        assertFalse(world.getRoom(0).containsPlayer());
    }

    @Test
    void contains_Returns_True_If_Room_Contains_Entity(){
        World world = new World(new TestableRoomCreator());
        Stone stone = new Stone();
        world.getRoom(0).setEntity(stone, new Position(1,1));
        assertTrue(world.getRoom(0).contains(stone));
    }

    @Test
    void contains_Returns_False_If_Room_Not_Contains_Entity(){
        World world = new World(new TestableRoomCreator());
        Stone stone = new Stone();
        assertFalse(world.getRoom(0).contains(stone));
    }

    @Test
    void getRoomList_Returns_Unmodifiable_List(){
        TestableRoomCreator trc = new TestableRoomCreator();
        Room room = trc.loadRoom(0);
        assertEquals("UnmodifiableRandomAccessList", room.getRoomList().getClass().getSimpleName());
    }

    @Test
    void getWorld_Room_Has_World_Returns_World(){
        World world = new World(new TestableRoomCreator());
        assertEquals(world, world.getRoom(0).getWorld());
    }

    @Test
    void getWorld_Room_No_World_Returns_Null(){
        TestableRoomCreator trc = new TestableRoomCreator();
        Room room = trc.loadRoom(0);
        assertNull(room.getWorld());
    }


    @Test
    void toString_Is_Correct(){
        TestableRoomCreator trc = new TestableRoomCreator();
        Room room = trc.loadRoom(0);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Room: %s %n", room.getRoomNumber()));
        for (var row : room.getRoomList()) {
            sb.append(row + "\n");
        }
        assertEquals(sb.toString(), room.toString());
    }
}