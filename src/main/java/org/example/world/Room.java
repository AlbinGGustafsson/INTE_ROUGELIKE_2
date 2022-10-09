package org.example.world;

import java.util.ArrayList;

public class Room {

    private int leftDoorXPos, leftDoorYPos, rightDoorXPos, rightDoorYPos;

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

    public void setRightDoorPos(int rightDoorXPos, int rightDoorYPos) {
        this.rightDoorXPos = rightDoorXPos;
        this.rightDoorYPos = rightDoorYPos;
    }

    public void setLeftDoorPos(int leftDoorXPos, int leftDoorYPos) {
        this.leftDoorXPos = leftDoorXPos;
        this.leftDoorYPos = leftDoorYPos;
    }

    public void setNonStackableEntity(NonStackableEntity e, int x, int y) {
        room.get(y).get(x).setNonStackableEntity(e);
    }

    public void removeNonStackableEntity(int x, int y){
        room.get(y).get(x).removeNonStackableEntity();
    }

    public void moveNonStackableEntity(NonStackableEntity e, int oldX, int oldY, int newX, int newY){
        removeNonStackableEntity(oldX, oldY);
        setNonStackableEntity(e, newX, newY);
    }

    public int getLeftDoorXPos() {
        return leftDoorXPos;
    }

    public int getLeftDoorYPos() {
        return leftDoorYPos;
    }

    public int getRightDoorXPos() {
        return rightDoorXPos;
    }

    public int getRightDoorYPos() {
        return rightDoorYPos;
    }

    public Tile getTile(int x, int y){
        return room.get(y).get(x);
    }

    public World getWorld() {
        return world;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return RoomType;
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
