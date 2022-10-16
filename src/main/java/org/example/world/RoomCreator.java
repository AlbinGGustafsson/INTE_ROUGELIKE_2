package org.example.world;

import javafx.animation.KeyValue;
import javafx.util.Pair;
import org.example.Monster.Goomba;
import org.example.Monster.Troll;

import java.io.*;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RoomCreator {

    private static final String NORMAL_ROOMS_FOLDER_PATH = "rooms/NormalRooms/";
    private static final String BOSS_ROOM_FOLDER_PATH = "rooms/BossRooms/";
    private static final String START_ROOM_FOLDER_PATH = "rooms/startRooms/";

    private static final String[] ACCEPTED_ROOM_TYPES = {"NormalRoom", "BossRoom", "StartRoom"};

    record RoomInformation(int roomHeight, int roomWidth, String roomType){}

    private Random random = new Random();
    protected int bossRoomChance = 10;

    public Room loadRoom(int roomNumber) {
        checkBossRoomChance();
        String filePath = generateRoomFilePath(roomNumber, NORMAL_ROOMS_FOLDER_PATH, BOSS_ROOM_FOLDER_PATH, START_ROOM_FOLDER_PATH);
        BufferedReader bufferedReader = createBufferedReader(filePath);
        RoomInformation roomInformation = readRoomInformation(bufferedReader);
        checkRoomSize(roomInformation);
        checkRoomType(roomInformation);
        return createRoom(roomNumber, roomInformation, bufferedReader);
    }

    protected void checkRoomSize(RoomInformation roomInformation){
        if (roomInformation.roomWidth < 3){
            throw new IllegalArgumentException("Room width too low");
        }
        if (roomInformation.roomHeight < 3){
            throw new IllegalArgumentException("Room height too low");
        }
        if (roomInformation.roomWidth > 30){
            throw new IllegalArgumentException("Room width too high");
        }
        if (roomInformation.roomHeight > 30){
            throw new IllegalArgumentException("Room height too high");
        }
    }

    protected void checkRoomType(RoomInformation roomInformation){
        if (!Arrays.asList(ACCEPTED_ROOM_TYPES).contains(roomInformation.roomType)){
            throw new IllegalArgumentException("Not accepted roomtype");
        }
    }

    protected void checkBossRoomChance(){
        if (bossRoomChance < 1){
            throw new IllegalArgumentException("Boss chance constant must be >=0");
        }
    }

    //todo
    //Se över hur exceptions ska hanteras
    protected String generateRoomFilePath(int roomNumber, String normalRoomFp, String bossRoomFp, String startRoomFp) {

        try {
            File normalRoomsFolder = new File(normalRoomFp);
            File[] normalRooms = normalRoomsFolder.listFiles();

            File bossRoomsFolder = new File(bossRoomFp);
            File[] bossRooms = bossRoomsFolder.listFiles();

            File startRoomsFolder = new File(startRoomFp);
            File[] startRooms = startRoomsFolder.listFiles();

            if (roomNumber == 0) {
                int startRoomIndex = random.nextInt(startRooms.length);
                return startRooms[startRoomIndex].getPath();
            } else if (random.nextInt(bossRoomChance) == bossRoomChance - 1) {
                int bossRoomIndex = random.nextInt(bossRooms.length);
                return bossRooms[bossRoomIndex].getPath();
            }
            int normalRoomIndex = random.nextInt(normalRooms.length);
            return normalRooms[normalRoomIndex].getPath();

        } catch (NullPointerException e) {
            throw new NullPointerException("No files found in directory");
        }
    }

    protected BufferedReader createBufferedReader(String filePath){
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            return bufferedReader;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
    }

    protected RoomInformation readRoomInformation(BufferedReader bufferedReader){

        try {
            String roomType = bufferedReader.readLine();
            int roomHeight = Integer.parseInt(bufferedReader.readLine());
            int roomWidth = Integer.parseInt(bufferedReader.readLine());

            return new RoomInformation(roomHeight, roomWidth, roomType);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    private Room createRoom(int roomNumber, RoomInformation roomInformation, BufferedReader bufferedReader){

        ArrayList<ArrayList<Tile>> room = new ArrayList<>();
        Room roomInCreation = new Room(room, roomNumber, roomInformation.roomType);

        try{
            for (int y = 0; y < roomInformation.roomHeight; y++) {
                char[] chars = bufferedReader.readLine().toCharArray();
                ArrayList<Tile> row = new ArrayList<>();
                room.add(row);
                for (int x = 0; x < roomInformation.roomWidth; x++) {
                    Position currentPosition = new Position(x, y);
                    switch (chars[x]){
                        case '#':{
                            row.add(new Tile(new Floor(), new Wall()));
                            break;
                        }
                        case 'F':{
                            row.add(new Tile(new Floor()));
                            break;
                        }
                        case 'L':{
                            row.add(new Tile(new Floor()));
                            roomInCreation.setEntity(new Door(Direction.LEFT), currentPosition);
                            break;
                        }
                        case 'R':{
                            row.add(new Tile(new Floor()));
                            roomInCreation.setEntity(new Door(Direction.RIGHT), currentPosition);
                            break;
                        }
                        case 'W':{
                            row.add(new Tile(new Water()));
                            break;
                        }
                        case 'T':{
                            row.add(new Tile(new Floor()));
                            roomInCreation.setEntity(new Troll(roomNumber+1), currentPosition);
                        }
                        case 'G':{
                            row.add(new Tile(new Floor()));
                            roomInCreation.setEntity(new Goomba(roomNumber+1), currentPosition);
                        }

                    }
                }
            }

            return roomInCreation;
        }catch (IOException e){
            throw new RuntimeException();
        }

    }
}
