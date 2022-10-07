package org.example.world;

import java.util.ArrayList;

public class World {

    private int worldHeight = 10;
    private int worldWidth = 10;

    private RoomLoader roomLoader = new RoomLoader();
    private ArrayList<ArrayList<Room>> world = new ArrayList<>();
    public World() {

        for (int y = 0; y < worldHeight; y++){
            ArrayList<Room> row = new ArrayList<>();
            world.add(row);
            for (int x = 0; x < worldWidth; x++){
                row.add(roomLoader.createRoom(x, y, this));
            }
        }
    }

    public Room getRoom(int x, int y){
        return world.get(y).get(x);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (var row : world){

            for (var room : row){
                sb.append(room.roomType() + "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
