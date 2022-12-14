package org.roguelike.world;

import org.roguelike.characters.Player;

import java.util.ArrayList;

public class World {
    private final RoomCreator roomCreator;
    private final ArrayList<Room> world = new ArrayList<>();

    public World() {
        this(new RoomCreator());
    }

    public World(RoomCreator roomCreator) {
        this.roomCreator = roomCreator;
        addRoom();
    }

    public void addRoom() {
        Room room = roomCreator.loadRoom(world.size());
        world.add(room);
        room.setWorld(this);
    }

    public Room getRoom(int roomNumber) {
        if (roomNumber > world.size() - 1){
            return null;
        }
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
            stringToAppend = r.containsPlayer() ? String.format("(P)%s ", r.mapString()) : r.mapString() + " ";
            sb.append(stringToAppend);
        }
        return sb.toString();
    }
}
