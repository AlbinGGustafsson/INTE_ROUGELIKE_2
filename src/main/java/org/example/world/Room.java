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

    public void setRightDoorPos(Position position) {
        rightDoorPos = position;
    }

    public void setLeftDoorPos(Position position) {
        leftDoorPos = position;
    }

    public void setNonStackableEntity(NonStackableEntity e, int x, int y) {
        room.get(y).get(x).setNonStackableEntity(e);
    }

    public void removeNonStackableEntity(int x, int y) {
        room.get(y).get(x).removeNonStackableEntity();
    }

    public void moveNonStackableEntity(NonStackableEntity e, int oldX, int oldY, int newX, int newY) {
        removeNonStackableEntity(oldX, oldY);
        setNonStackableEntity(e, newX, newY);
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
                if (t.getNonStackableEntity() instanceof Player) {
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
