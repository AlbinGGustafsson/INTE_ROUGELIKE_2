package org.example.world;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RoomCreator {

    private Random random = new Random();

    //kanske inte ska vara en konstant i framtiden
    private static final int BOSS_ROOM_CHANCE = 10;


    //todo
    //Se över hur exceptions ska hanteras
    //om det inte finns en fil i directoryt som man kollar i så kommer null returneras som room och vi kommer få ett null pointer senare
    private String generateRoomFilePath(int roomNumber) {

        try {
            File normalRoomsFolder = new File("rooms/NormalRooms/");
            File[] normalRooms = normalRoomsFolder.listFiles();

            File bossRoomsFolder = new File("rooms/BossRooms/");
            File[] bossRooms = bossRoomsFolder.listFiles();

            File startRoomsFolder = new File("rooms/startRooms/");
            File[] startRooms = startRoomsFolder.listFiles();

            if (roomNumber == 0) {
                int startRoomIndex = random.nextInt(startRooms.length);
                return startRooms[startRoomIndex].getPath();
            } else if (random.nextInt(BOSS_ROOM_CHANCE) == BOSS_ROOM_CHANCE - 1) {
                int bossRoomIndex = random.nextInt(bossRooms.length);
                return bossRooms[bossRoomIndex].getPath();
            }
            int normalRoomIndex = random.nextInt(normalRooms.length);
            return normalRooms[normalRoomIndex].getPath();
        } catch (NullPointerException | IllegalArgumentException e) {
            System.err.println("No file in directory");
        }
        return "";
    }

    public Room loadRoom(int roomNumber, World world) {

        String filePath = generateRoomFilePath(roomNumber);

        ArrayList<ArrayList<Tile>> room = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //todo
            //borde ha ett minvärde på kanske.... 5
            //kanske ska fånga lite exceptions också

            String roomType = bufferedReader.readLine();
            int roomHeight = Integer.parseInt(bufferedReader.readLine());
            int roomWidth = Integer.parseInt(bufferedReader.readLine());

            Room roomInCreation = new Room(room, world, roomNumber, roomType);

            for (int y = 0; y < roomHeight; y++) {
                char[] chars = bufferedReader.readLine().toCharArray();
                ArrayList<Tile> row = new ArrayList<>();
                room.add(row);
                for (int x = 0; x < roomWidth; x++) {
                    if (chars[x] == '#') {
                        row.add(new Tile(new Wall()));
                    }
                    if (chars[x] == 'F') {
                        row.add(new Tile(new Floor()));
                    }
                    if (chars[x] == 'L') {
                        row.add(new Tile(new LeftDoor()));
                        roomInCreation.setLeftDoorPos(x, y);
                    }
                    if (chars[x] == 'R') {
                        row.add(new Tile(new RightDoor()));
                        roomInCreation.setRightDoorPos(x, y);
                    }
                    if (chars[x] == 'W') {
                        row.add(new Tile(new Water()));
                        roomInCreation.setRightDoorPos(x, y);
                    }
                }
            }

            return roomInCreation;

        } catch (FileNotFoundException fe) {
            System.err.println("File not found");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
