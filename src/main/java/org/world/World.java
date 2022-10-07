package org.world;

import java.util.ArrayList;

public class World {

    private int worldHeight = 10;
    private int worldWidth = 10;

    private ArrayList<ArrayList<Room>> world = new ArrayList<>();
    public World() {

        for (int i = 0; i < worldHeight; i++){
            ArrayList<Room> row = new ArrayList<>();
            world.add(row);
            for (int j = 0; j < worldWidth; j++){
                row.add(new Room());
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
