package org.example.world;

import org.example.Player;

import java.util.ArrayList;

public class World {
    private RoomCreator roomLoader = new RoomCreator();
    private ArrayList<Room> world = new ArrayList<>();

    public World() {
        addRoom();
    }

    public void addRoom() {
        Room room = roomLoader.loadRoom(world.size(), this);
        world.add(room);
    }

    public Room getRoom(int roomNumber) {
        return world.get(roomNumber);
    }

    public void spawnPlayer(Player player){
        Position pos = new Position(1,1);
        getRoom(0).setEntity(player, pos);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Room r : world) {
            String stringToAppend;
            stringToAppend = r.containsPlayer() ? String.format("(%sP%s)%s", PrintFormatConstants.PURPLE, PrintFormatConstants.RESET, r.mapString()) + " " : r.mapString() + " ";
            sb.append(stringToAppend);
        }
        return sb.toString();
    }
}
