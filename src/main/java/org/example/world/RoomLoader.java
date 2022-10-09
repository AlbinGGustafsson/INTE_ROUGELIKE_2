package org.example.world;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RoomLoader {

    public Room createRoom(int roomNumber, World world){

        String file = "";

        if (roomNumber == 0){
            file = "rooms/1.txt";
        }

        ArrayList<ArrayList<Tile>> roomList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
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
                    if (chars[x] == 'L'){
                        row.add(new Tile(new Door(Direction.LEFT)));
                    }
                    if (chars[x] == 'R'){
                        row.add(new Tile(new Door(Direction.RIGHT)));
                    }
                }
            }

            //Här ska väl ett rum retureras


        }catch (FileNotFoundException fe){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
