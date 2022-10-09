package org.example.world;

import java.util.ArrayList;

public class World {

    private RoomLoader roomLoader = new RoomLoader();
    private ArrayList<Room> world;

    public World() {
        world = new ArrayList<>();
        Room baseRoom = roomLoader.createRoom(0, this);
        world.add(baseRoom);
    }

    public Room getRoom(int roomNumber) {
        return world.get(roomNumber);
    }

}
