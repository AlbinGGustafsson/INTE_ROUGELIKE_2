package org.example.world;

import java.util.ArrayList;

public class World {
    private RoomLoader roomLoader = new RoomLoader();
    private ArrayList<Room> world = new ArrayList<>();

    public World() {
        addRoom();
    }

    public void addRoom(){
        Room room = roomLoader.createRoom(world.size(), this);
        world.add(room);
    }

    public Room getRoom(int roomNumber) {
        return world.get(roomNumber);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Room r : world){

            String s;
            boolean containsPlayer = r.containsPlayer();

            s = r.containsPlayer() ? "(P)" + r.mapString() + " " : r.mapString() + " ";
            sb.append(s);


        }
        return sb.toString();
    }
}
