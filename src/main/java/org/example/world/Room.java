package org.example.world;

import org.example.characters.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {
    private int roomNumber;
    private World world;
    private String RoomType;

    protected ArrayList<ArrayList<Tile>> roomList;

    public Room(ArrayList<ArrayList<Tile>> room, int roomNumber, String roomType) {
        this.roomList = room;
        this.roomNumber = roomNumber;
        this.RoomType = roomType;
    }

    public Room getNextRoom() {

        if (world == null){
            throw new RuntimeException("Room has no world");
            //return null;
        }

        if (world.getRoom(roomNumber + 1) == null){
            world.addRoom();
        }
        return world.getRoom(roomNumber + 1);
    }

    public Room getPreviousRoom() {

        if (world == null){
            throw new RuntimeException("Room has no world");
            //return null;
        }
        if (roomNumber == 0) {
            throw new RuntimeException("Cant go left from room number 0");
        }
        return world.getRoom(roomNumber - 1);
    }

    public void setEntity(Entity entity, Position pos) {
        Tile tile = roomList.get(pos.getY()).get(pos.getX());
        if (getTile(pos).canSetEntity(entity)) {
            tile.setEntity(entity);
            entity.updateRoom(this);
            entity.updatePosition(pos, this);
        }
    }

    public void removeEntity(Entity entity) {
        if (contains(entity)){
            Position pos = entity.getPosition();
            roomList.get(pos.getY()).get(pos.getX()).removeEntity();
            entity.updateRoom(null);
        }
    }

    public void moveEntity(Entity entity, Position newPos) {
        if (getTile(newPos).canSetEntity(entity) && contains(entity)){
            removeEntity(entity);
            setEntity(entity, newPos);
        }
    }

    public Door getDoor(Direction direction) {
        for (ArrayList<Tile> list : roomList) {
            for (Tile t : list) {
                if (t.getEntity() instanceof Door d && d.getDirection().equals(direction)) {
                    return d;
                }
            }
        }
        return null;
    }
    public Tile getTile(Position position) {
        try{
            return roomList.get(position.getY()).get(position.getX());
        }catch (IndexOutOfBoundsException e){
            return null;
        }
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

    public void setWorld(World world) {
        this.world = world;
    }

    public boolean containsPlayer() {

        for (ArrayList<Tile> list : roomList) {
            for (Tile t : list) {
                if (t.getEntity() instanceof Player) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean contains(Entity entity){
        for (ArrayList<Tile> list : roomList) {
            for (Tile t : list) {
                if (t.getEntity() != null && t.getEntity().equals(entity)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getRoomType() {
        return RoomType;
    }

    public List<ArrayList<Tile>> getRoomList() {
        return Collections.unmodifiableList(roomList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Room: %s %n", roomNumber));
        for (var row : roomList) {
            sb.append(row + "\n");
        }

        return sb.toString();
    }

}
