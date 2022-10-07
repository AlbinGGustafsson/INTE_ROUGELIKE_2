package org.example.world;

import java.util.ArrayList;

public class Room {

    private int roomHeight = 9;
    private int roomWidth = 9;

    ArrayList<ArrayList<Tile>> room = new ArrayList<>();

    public Room() {
        for (int i = 0; i < roomHeight; i++){
            ArrayList<Tile> row = new ArrayList();
            room.add(row);
            for (int j = 0; j < roomWidth; j++){
                if (i == 0 || i == roomHeight-1 || j == 0 || j == roomWidth-1){
                    row.add(new Tile(new Wall()));
                }else {
                    row.add(new Tile(new Grass()));
                }
            }
        }
    }

    public void addEntity(Entity entity, int x, int y){
        room.get(y).get(x).addEntity(entity);
    }
    public Tile getTile(int x, int y){
        return room.get(y).get(x);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var r : room){
            sb.append(r+"\n");
        }
        return sb.toString();
    }
}
