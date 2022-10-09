package org.example.world;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RoomLoader {

    private Random random = new Random();


    public Room createRoom(int roomNumber, World world) {

        //todo
        //Bryt ut detta till egen metod
        String roomType = "";
        String file = "";
        if (roomNumber == 0) {
            file = "rooms/StartRoom.txt";
            roomType = "StartRoom";
        } else if (random.nextInt(10) == 9) {
            file = "rooms/BossRoom1.txt";
            roomType = "BossRoom";
        }else {
            file = "rooms/NormalRoom1.txt";
            roomType = "NormalRoom";
        }

        ArrayList<ArrayList<Tile>> roomList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //todo
            //borde ha ett minvärde på kanske.... 5
            //kanske ska fånga lite exceptions också

            Room roomInCreation = new Room(roomList, world, roomNumber, roomType);

            int roomHeight = Integer.parseInt(bufferedReader.readLine());
            int roomWidth = Integer.parseInt(bufferedReader.readLine());

            for (int y = 0; y < roomHeight; y++) {
                char[] chars = bufferedReader.readLine().toCharArray();
                ArrayList<Tile> row = new ArrayList<>();
                roomList.add(row);
                for (int x = 0; x < roomWidth; x++) {
                    if (chars[x] == 'W') {
                        row.add(new Tile(new Wall()));
                    }
                    if (chars[x] == 'F') {
                        row.add(new Tile(new Floor()));
                    }
                    if (chars[x] == 'L') {
                        row.add(new Tile(new Door(DoorDirection.LEFT)));
                        roomInCreation.setLeftDoorPos(x, y);
                    }
                    if (chars[x] == 'R') {
                        row.add(new Tile(new Door(DoorDirection.RIGHT)));
                        roomInCreation.setRightDoorPos(x, y);
                    }
                }
            }

            return roomInCreation;

        } catch (FileNotFoundException fe) {
            fe.printStackTrace();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
