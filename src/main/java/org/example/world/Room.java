package org.example.world;

import java.util.ArrayList;

public abstract class Room {

    private int x, y;
    private World world;

    protected ArrayList<ArrayList<Tile>> room = new ArrayList<>();

    public Room(ArrayList<ArrayList<Tile>> room, World world, int x, int y) {
        this.room = room;
        this.x = x;
        this.y = y;
        this.world = world;
    }

    public void addNonStackableEntity(NonStackableEntity e, int x, int y) {
        room.get(y).get(x).setNonStackableEntity(e);
    }

    public void removeNonStackableEntity(int x, int y){
        room.get(y).get(x).removeNonStackableEntity();
    }

    public Tile getTile(int x, int y){
        return room.get(y).get(x);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public World getWorld() {
        return world;
    }

    public int getRoomHeight(){
        return room.size();
    }
    public int getRoomWidth(){
        return room.get(0).size();
    }

    public abstract String roomType();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Room: X = %d Y = %d %n", x, y));
        for (var row : room) {
            sb.append(row + "\n");
        }
        return sb.toString();
    }

}
