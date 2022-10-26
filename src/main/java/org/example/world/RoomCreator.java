package org.example.world;

import org.example.Monster.Goomba;
import org.example.Monster.Seamonster;
import org.example.Monster.Troll;
import org.example.Quest;
import org.example.Race;
import org.example.characters.NPCCreator;
import org.example.characters.QuestGiver;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RoomCreator {

    private static final int MIN_ROOM_SIZE = 3;
    private static final int MAX_ROOM_SIZE = 30;
    private static final String NORMAL_ROOMS_FOLDER_PATH = "rooms/NormalRooms/";
    private static final String BOSS_ROOM_FOLDER_PATH = "rooms/BossRooms/";
    private static final String START_ROOM_FOLDER_PATH = "rooms/startRooms/";

    private static final String[] ACCEPTED_ROOM_TYPES = {"NormalRoom", "BossRoom", "StartRoom"};

    protected record RoomInformation(int roomHeight, int roomWidth, String roomType){}

    private final Random random = new Random();

    private NPCCreator npcCreator = new NPCCreator();

    private int bossRoomChance = 10;

    public Room loadRoom(int roomNumber) {
        throwExceptionIfBossRoomChanceNotAllowed();
        String filePath = generateRoomFilePath(roomNumber, NORMAL_ROOMS_FOLDER_PATH, BOSS_ROOM_FOLDER_PATH, START_ROOM_FOLDER_PATH);
        BufferedReader bufferedReader = createBufferedReader(filePath);
        RoomInformation roomInformation = parseRoomInformation(bufferedReader);
        throwExceptionIfRoomSizeNotAllowed(roomInformation);
        throwExceptionIfRoomTypeNotAllowed(roomInformation);
        return createRoom(roomNumber, roomInformation, bufferedReader);
    }

    protected void throwExceptionIfRoomSizeNotAllowed(RoomInformation roomInformation){
        if (roomInformation.roomWidth < MIN_ROOM_SIZE){
            throw new IllegalArgumentException("Room width too low");
        }
        if (roomInformation.roomHeight < MIN_ROOM_SIZE){
            throw new IllegalArgumentException("Room height too low");
        }
        if (roomInformation.roomWidth > MAX_ROOM_SIZE){
            throw new IllegalArgumentException("Room width too high");
        }
        if (roomInformation.roomHeight > MAX_ROOM_SIZE){
            throw new IllegalArgumentException("Room height too high");
        }
    }

    protected void throwExceptionIfRoomTypeNotAllowed(RoomInformation roomInformation){
        if (!Arrays.asList(ACCEPTED_ROOM_TYPES).contains(roomInformation.roomType)){
            throw new IllegalArgumentException("Not accepted roomtype");
        }
    }

    protected void throwExceptionIfBossRoomChanceNotAllowed(){
        if (bossRoomChance < 1){
            throw new IllegalArgumentException("Boss chance constant must be >=0");
        }
    }

    protected String generateRoomFilePath(int roomNumber, String normalRoomFp, String bossRoomFp, String startRoomFp) {

        try {
            File[] normalRooms = createFileArray(normalRoomFp);
            File[] bossRooms = createFileArray(bossRoomFp);
            File[] startRooms = createFileArray(startRoomFp);
            return getGeneratedFilePath(roomNumber, startRooms, bossRooms, normalRooms);

        } catch (NullPointerException e) {
            throw new NullPointerException("No files found in directory");
        }
    }

    private String getGeneratedFilePath(int roomNumber, File[] startRooms, File[] bossRooms, File[] normalRooms){

        if (roomNumber == 0) {
            int startRoomIndex = random.nextInt(startRooms.length);
            return startRooms[startRoomIndex].getPath();
        } else if (random.nextInt(bossRoomChance) == bossRoomChance - 1) {
            int bossRoomIndex = random.nextInt(bossRooms.length);
            return bossRooms[bossRoomIndex].getPath();
        }
        int normalRoomIndex = random.nextInt(normalRooms.length);
        return normalRooms[normalRoomIndex].getPath();
    }

    private File[] createFileArray(String folderPath){
        File roomFolder = new File(folderPath);
        return roomFolder.listFiles();
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

    protected RoomInformation parseRoomInformation(BufferedReader bufferedReader){

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
                            break;
                        }
                        case 'G':{
                            row.add(new Tile(new Floor()));
                            roomInCreation.setEntity(new Goomba(roomNumber+1), currentPosition);
                            break;
                        }
                        case 'S':{
                            row.add(new Tile(new Floor()));
                            roomInCreation.setEntity(new Seamonster(roomNumber+1), currentPosition);
                            break;
                        }
                        case 'Q':{
                            row.add(new Tile(new Floor()));
                            roomInCreation.setEntity(npcCreator.getQuestGiver(), currentPosition);
                            break;
                        }
                        case 'V':{
                            row.add(new Tile(new Floor()));
                            roomInCreation.setEntity(npcCreator.getVendor(), currentPosition);
                            break;
                        }
                        case 'N':{
                            row.add(new Tile(new Floor()));
                            roomInCreation.setEntity(npcCreator.getFlavorNPC(), currentPosition);
                            break;
                        }
                    }
                }
            }

            return roomInCreation;
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void setBossRoomChance(int bossRoomChance) {
        this.bossRoomChance = bossRoomChance;
    }
}
