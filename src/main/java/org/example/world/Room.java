package org.example.world;

import org.example.Player;

import java.util.ArrayList;

public class Room {

    private Position leftDoorPos, rightDoorPos;

    private int roomNumber;
    private World world;
    private String RoomType;

    protected ArrayList<ArrayList<Tile>> room;

    public Room(ArrayList<ArrayList<Tile>> room, World world, int roomNumber, String roomType) {
        this.room = room;
        this.world = world;
        this.roomNumber = roomNumber;
        this.RoomType = roomType;
    }

    public Room getNextRoom(){
        try{
            world.getRoom(roomNumber + 1);
        }catch (IndexOutOfBoundsException e){
            world.addRoom();
        }
        return world.getRoom(roomNumber + 1);
    }

    public Room getPreviousRoom(){
        if (roomNumber == 0){
            return null;
        }
        return world.getRoom(roomNumber - 1);
    }

    public void setRightDoorPos(Position position) {
        rightDoorPos = position;
    }

    public void setLeftDoorPos(Position position) {
        leftDoorPos = position;
    }

    public void setEntity(Entity e, Position pos) {
        room.get(pos.getY()).get(pos.getX()).setEntity(e);
    }

    public void removeEntity(Position pos) {
        room.get(pos.getY()).get(pos.getX()).removeEntity();
    }

    public void moveEntity(Entity e, Position oldPos, Position newPos) {
        removeEntity(oldPos);
        setEntity(e, newPos);
    }

    public Position getLeftDoorPos() {
        return leftDoorPos;
    }

    public Position getRightDoorPos() {
        return rightDoorPos;
    }

    public Tile getTile(Position position) {
        return room.get(position.getY()).get(position.getX());
    }

    public World getWorld() {
        return world;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String mapString() {
        return RoomType;
    }

    public boolean containsPlayer() {

        for (ArrayList<Tile> list : room) {
            for (Tile t : list) {
                if (t.getEntity() instanceof Player) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Room: %s %n", roomNumber));
        for (var row : room) {
            sb.append(row + "\n");
        }
        return sb.toString();
    }

}
