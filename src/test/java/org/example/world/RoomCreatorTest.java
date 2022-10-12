package org.example.world;


import org.junit.jupiter.api.Test;


import java.io.BufferedReader;
import java.io.StringReader;
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
        rc.bossRoomChance = 0;
        assertThrows(IllegalArgumentException.class, () -> rc.checkBossRoomChance());
    }

    @Test
    void roomInformation_Is_Loaded_Correct(){
        RoomCreator.RoomInformation referenceRoomInformation = new RoomCreator.RoomInformation(9,9, "StartRoom");
        TestableRoomCreator trc = new TestableRoomCreator();

        String roomString = trc.generateRoomFilePath(0, "Dummy", "Dummy", "Dummy");
        BufferedReader bufferedReader = trc.createBufferedReader(roomString);
        RoomCreator.RoomInformation roomInformation = trc.readRoomInformation(bufferedReader);
        assertEquals(referenceRoomInformation, roomInformation);
    }

    @Test
    void room_Created_Correct(){
        TestableRoomCreator trc = new TestableRoomCreator();
        Room room = trc.loadRoom(1);
        Room normalRoomReference = createNormalRoomReference();
        assertEquals(normalRoomReference.toString(), room.toString());
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
        assertThrows(IllegalArgumentException.class, () -> rc.checkRoomSize(roomInformation));
    }

    @Test
    void room_Width_To_High_Throws_Exception(){
        RoomCreator rc = new RoomCreator();
        RoomCreator.RoomInformation roomInformation = new RoomCreator.RoomInformation(10, 31, "NormalRoom");
        assertThrows(IllegalArgumentException.class, () -> rc.checkRoomSize(roomInformation));
    }

    @Test
    void room_Height_To_Low_Throws_Exception(){
        RoomCreator rc = new RoomCreator();
        RoomCreator.RoomInformation roomInformation = new RoomCreator.RoomInformation(2, 10, "NormalRoom");
        assertThrows(IllegalArgumentException.class, () -> rc.checkRoomSize(roomInformation));
    }

    @Test
    void room_Height_To_High_Throws_Exception(){
        RoomCreator rc = new RoomCreator();
        RoomCreator.RoomInformation roomInformation = new RoomCreator.RoomInformation(31, 10, "NormalRoom");
        assertThrows(IllegalArgumentException.class, () -> rc.checkRoomSize(roomInformation));
    }

    @Test
    void not_Accepted_RoomType_Throws_exception(){
        RoomCreator rc = new RoomCreator();
        RoomCreator.RoomInformation roomInformation = new RoomCreator.RoomInformation(31, 10, "NotAValidRoomType");
        assertThrows(IllegalArgumentException.class, () -> rc.checkRoomType(roomInformation));
    }

    private Room createNormalRoomReference(){

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

    class TestableRoomCreator extends RoomCreator{

        //Istället för att ha med slumplogik
        @Override
        protected String generateRoomFilePath(int roomNumber, String normalRoomFp, String bossRoomFp, String startRoomFp) {

            if (roomNumber == 0){
                return Rooms.START_ROOM;
            }
            if (roomNumber == 1){
                return Rooms.NORMAL_ROOM;
            }
            if (roomNumber == 2){
                return Rooms.BOSS_ROOM;
            }
            return "";
        }

        //istället för att ha en bufferedreader som läser från en fil på på hårdisken.
        @Override
        protected BufferedReader createBufferedReader(String filePath) {
            return new BufferedReader(new StringReader(filePath));
        }
    }

    static class Rooms{

        private static final String NORMAL_ROOM =
                "NormalRoom\n" +
                "5\n" +
                "5\n" +
                "#####\n" +
                "#FFW#\n" +
                "LFFFR\n" +
                "#FFF#\n" +
                "#####";

        private static final String BOSS_ROOM =
                "BossRoom\n" +
                "9\n" +
                "9\n" +
                "#########\n" +
                "#FFFFFFF#\n" +
                "#FFFFFFF#\n" +
                "#FF###FF#\n" +
                "LFF###FFR\n" +
                "#FF###FF#\n" +
                "#FFFFFFF#\n" +
                "#FFFFFFF#\n" +
                "#########";

        private static final String START_ROOM =
                "StartRoom\n" +
                "9\n" +
                "9\n" +
                "#########\n" +
                "#FFFFFFW#\n" +
                "#FFFFFFF#\n" +
                "#FFFFFFF#\n" +
                "#FFFFFFFR\n" +
                "#FFFFFFF#\n" +
                "#FFFFFFF#\n" +
                "#FFFFFFF#\n" +
                "#########";

    }


}