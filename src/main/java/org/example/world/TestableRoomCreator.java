package org.example.world;

import java.io.BufferedReader;
import java.io.StringReader;

public class TestableRoomCreator extends RoomCreator {

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

            return Rooms.NORMAL_ROOM;
        }

        //istället för att ha en bufferedreader som läser från en fil på på hårdisken.
        @Override
        protected BufferedReader createBufferedReader(String filePath) {
            return new BufferedReader(new StringReader(filePath));
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
                        "#FFFFFTF#\n" +
                        "#########";

        private static final String START_ROOM = "StartRoom\n" +
                "6\n" +
                "6\n" +
                "######\n" +
                "#FFFW#\n" +
                "#FFFFR\n" +
                "#FFFF#\n" +
                "#FFFF#\n" +
                "######";

    }

}




