package org.example.world;

import javafx.animation.KeyValue;
import javafx.util.Pair;

import java.io.*;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RoomCreator {

    record RoomInformation(int roomHeight, int roomWidth, String roomType){}
    private Random random = new Random();
    private static final int BOSS_ROOM_CHANCE = 10;


    public Room loadRoom(int roomNumber, World world) {
        String filePath = generateRoomFilePath(roomNumber);
        BufferedReader bufferedReader = createBufferedReader(filePath);
        RoomInformation roomInformation = readRoomInformation(bufferedReader);
        return createRoom(roomNumber, world, roomInformation, bufferedReader);
    }

    //todo
    //Se över hur exceptions ska hanteras
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

        } catch (NullPointerException e) {
            throw new NullPointerException("No files found in directory");
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Boss chance constant must be >=0");
        }
    }

    private BufferedReader createBufferedReader(String filePath){
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            return bufferedReader;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
    }

    private RoomInformation readRoomInformation(BufferedReader bufferedReader){

        try {
            String roomType = bufferedReader.readLine();
            int roomHeight = Integer.parseInt(bufferedReader.readLine());
            int roomWidth = Integer.parseInt(bufferedReader.readLine());

            return new RoomInformation(roomHeight, roomWidth, roomType);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    private Room createRoom(int roomNumber, World world, RoomInformation roomInformation, BufferedReader bufferedReader){

        ArrayList<ArrayList<Tile>> room = new ArrayList<>();
        Room roomInCreation = new Room(room, world, roomNumber, roomInformation.roomType);

        try{
            for (int y = 0; y < roomInformation.roomHeight; y++) {
                char[] chars = bufferedReader.readLine().toCharArray();
                ArrayList<Tile> row = new ArrayList<>();
                room.add(row);
                for (int x = 0; x < roomInformation.roomWidth; x++) {
                    Position currentPosition = new Position(x, y);
                    if (chars[x] == '#') {
                        row.add(new Tile(new Floor(), new Wall()));
                    }
                    if (chars[x] == 'F') {
                        row.add(new Tile(new Floor()));
                    }
                    if (chars[x] == 'L') {
                        row.add(new Tile(new Floor()));
                        roomInCreation.setEntity(new Door(Direction.LEFT), currentPosition);
                    }
                    if (chars[x] == 'R') {
                        row.add(new Tile(new Floor()));
                        roomInCreation.setEntity(new Door(Direction.RIGHT), currentPosition);
                    }
                    if (chars[x] == 'W') {
                        row.add(new Tile(new Water()));

                    }
                }
            }

            return roomInCreation;
        }catch (IOException e){
            throw new RuntimeException();
        }

    }
}
