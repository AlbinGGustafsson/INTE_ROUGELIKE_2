package org.example.world;


import org.junit.jupiter.api.Test;


import java.io.BufferedReader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RoomCreatorTest {

    @Test
    void no_Files_In_Directory_Or_Not_Valid_Directory_Throws_Exception(){
        RoomCreator rc = new RoomCreator();
        assertThrows(NullPointerException.class, () -> rc.generateRoomFilePath(0, "NotAFilePath", "NotAFilePath", "NotAFilePath"));
    }

    @Test
    void boss_Room_Chance_Under_Min_Throws_Exception(){
        RoomCreator rc = new RoomCreator();
        rc.setBossRoomChance(0);
        assertThrows(IllegalArgumentException.class, () -> rc.throwExceptionIfBossRoomChanceNotAllowed());
    }

    @Test
    void roomInformation_Is_Loaded_Correct(){
        RoomCreator.RoomInformation referenceRoomInformation = new RoomCreator.RoomInformation(6,6, "StartRoom");
        TestableRoomCreator trc = new TestableRoomCreator();

        String roomString = trc.generateRoomFilePath(0, "Dummy", "Dummy", "Dummy");
        BufferedReader bufferedReader = trc.createBufferedReader(roomString);
        RoomCreator.RoomInformation roomInformation = trc.parseRoomInformation(bufferedReader);
        assertEquals(referenceRoomInformation, roomInformation);
    }

    @Test
    void room_Created_Correct(){
        TestableRoomCreator trc = new TestableRoomCreator();
        Room room = trc.loadRoom(1);
        Room expectedRoom = createExpectedRoom();
        assertEquals(expectedRoom.toString(), room.toString());
    }

    @Test
    void file_Not_Found_When_Creating_BufferedReader_Throws_Exception(){
        RoomCreator rc = new RoomCreator();
        assertThrows(RuntimeException.class, () -> rc.createBufferedReader("dummy"));
    }

    @Test
    void room_Width_To_Low_Throws_Exception(){
        RoomCreator rc = new RoomCreator();
        RoomCreator.RoomInformation roomInformation = new RoomCreator.RoomInformation(10, 2, "NormalRoom");
        assertThrows(IllegalArgumentException.class, () -> rc.throwExceptionIfRoomSizeNotAllowed(roomInformation));
    }

    @Test
    void room_Width_To_High_Throws_Exception(){
        RoomCreator rc = new RoomCreator();
        RoomCreator.RoomInformation roomInformation = new RoomCreator.RoomInformation(10, 31, "NormalRoom");
        assertThrows(IllegalArgumentException.class, () -> rc.throwExceptionIfRoomSizeNotAllowed(roomInformation));
    }

    @Test
    void room_Height_To_Low_Throws_Exception(){
        RoomCreator rc = new RoomCreator();
        RoomCreator.RoomInformation roomInformation = new RoomCreator.RoomInformation(2, 10, "NormalRoom");
        assertThrows(IllegalArgumentException.class, () -> rc.throwExceptionIfRoomSizeNotAllowed(roomInformation));
    }

    @Test
    void room_Height_To_High_Throws_Exception(){
        RoomCreator rc = new RoomCreator();
        RoomCreator.RoomInformation roomInformation = new RoomCreator.RoomInformation(31, 10, "NormalRoom");
        assertThrows(IllegalArgumentException.class, () -> rc.throwExceptionIfRoomSizeNotAllowed(roomInformation));
    }

    @Test
    void not_Accepted_RoomType_Throws_exception(){
        RoomCreator rc = new RoomCreator();
        RoomCreator.RoomInformation roomInformation = new RoomCreator.RoomInformation(31, 10, "NotAValidRoomType");
        assertThrows(IllegalArgumentException.class, () -> rc.throwExceptionIfRoomTypeNotAllowed(roomInformation));
    }

    private Room createExpectedRoom(){

        ArrayList<ArrayList<Tile>> room = new ArrayList<>();
        ArrayList<Tile> row1 = new ArrayList<>();
        ArrayList<Tile> row2 = new ArrayList<>();
        ArrayList<Tile> row3 = new ArrayList<>();
        ArrayList<Tile> row4 = new ArrayList<>();
        ArrayList<Tile> row5 = new ArrayList<>();
        room.add(row1);
        room.add(row2);
        room.add(row3);
        room.add(row4);
        room.add(row5);

        Tile floorTile = new Tile(new Floor());
        Tile waterTile = new Tile(new Water());

        Tile leftDoorTile = new Tile(new Floor());
        Tile rightDoorTile = new Tile(new Floor());
        leftDoorTile.setEntity(new Door(Direction.LEFT));
        rightDoorTile.setEntity(new Door((Direction.RIGHT)));

        Tile wallTile = new Tile(new Floor());
        wallTile.setEntity(new Wall());

        for (int i = 0; i < 5; i++){
            row1.add(wallTile);
            row5.add(wallTile);
        }

        row2.add(wallTile);
        row2.add(floorTile);
        row2.add(floorTile);
        row2.add(waterTile);
        row2.add(wallTile);

        row3.add(leftDoorTile);
        row3.add(floorTile);
        row3.add(floorTile);
        row3.add(floorTile);
        row3.add(rightDoorTile);

        row4.add(wallTile);
        row4.add(floorTile);
        row4.add(floorTile);
        row4.add(floorTile);
        row4.add(wallTile);


        return new Room(room, 1, "NormalRoom");
    }
}