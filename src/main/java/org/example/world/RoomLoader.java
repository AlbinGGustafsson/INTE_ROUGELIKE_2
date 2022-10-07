package org.example.world;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RoomLoader {

    public Room createRoom(int roomX, int roomY, World world){

        ArrayList<ArrayList<Tile>> roomList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("rooms/1.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String roomType = bufferedReader.readLine();
            //todo
            //borde ha ett minvärde på kanske.... 5
            //kanske ska fånga lite exceptions också
            int roomHeight = Integer.parseInt(bufferedReader.readLine());
            int roomWidth = Integer.parseInt(bufferedReader.readLine());

            for (int y = 0; y < roomHeight; y++){
                char[] chars = bufferedReader.readLine().toCharArray();
                ArrayList<Tile> row = new ArrayList<>();
                roomList.add(row);
                for (int x = 0; x < roomWidth; x++){
                    if (chars[x] == 'W'){
                        row.add(new Tile(new Wall()));
                    }
                    if (chars[x] == 'F'){
                        row.add(new Tile(new Floor()));
                    }
                    if (chars[x] == 'D'){
                        row.add(new Tile(new Door(calculateDoorDirection(x, y, roomHeight, roomWidth))));
                    }
                }
            }

            if (roomType.equals("DungeonRoom")){
                return new DungeonRoom(roomList, world, roomX, roomY);
            }
            if (roomType.equals("VoidRoom")){
                return new VoidRoom(roomList, world, roomX, roomY);
            }
            if (roomType.equals("CorridorRoom")){
                return new CorridorRoom(roomList, world, roomX, roomY);
            }

        }catch (FileNotFoundException fe){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    private Direction calculateDoorDirection(int x, int y, int roomHeight, int roomWidth){
        if (y == 0){
            return Direction.NORTH;
        }
        if (y == roomHeight-1){
            return Direction.SOUTH;
        }
        if (x == 0){
            return Direction.WEST;
        }

        return Direction.EAST;
    }

}
