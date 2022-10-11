package org.example.world;

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
        player.setRoom(getRoom(0));
        player.setPos(pos);
        getRoom(0).setNonStackableEntity(player, player.getPosition());
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
