package org.example.world;

import javafx.geometry.Pos;
import org.example.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {
    private int roomNumber;
    private World world;
    private String RoomType;

    protected ArrayList<ArrayList<Tile>> room;

    public Room(ArrayList<ArrayList<Tile>> room, int roomNumber, String roomType) {
        this.room = room;
        //this.world = world;
        this.roomNumber = roomNumber;
        this.RoomType = roomType;
    }

    public Room getNextRoom() {
        try {
            world.getRoom(roomNumber + 1);
        } catch (IndexOutOfBoundsException e) {
            world.addRoom();
        }
        return world.getRoom(roomNumber + 1);
    }

    public Room getPreviousRoom() {
        if (roomNumber == 0) {
            return null;
        }
        return world.getRoom(roomNumber - 1);
    }

    public void setEntity(Entity entity, Position pos) {
        Tile tile = room.get(pos.getY()).get(pos.getX());
        if (getTile(pos).canSetEntity(entity)) {
            tile.setEntity(entity);
            entity.updateRoom(this);
            entity.updatePosition(pos, this);
        }
    }

    public void removeEntity(Entity entity) {
        Position pos = entity.getPosition();
        room.get(pos.getY()).get(pos.getX()).removeEntity();
    }

    public void moveEntity(Entity entity, Position newPos) {
        if (getTile(newPos).canSetEntity(entity)){
            removeEntity(entity);
            setEntity(entity, newPos);
        }
    }

    public Door getDoor(Direction direction) {
        for (ArrayList<Tile> list : room) {
            for (Tile t : list) {
                if (t.getEntity() instanceof Door d && d.getDirection().equals(direction)) {
                    return d;
                }
            }
        }
        return null;
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

    public void setWorld(World world) {
        this.world = world;
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
    public boolean contains(Entity entity){
        for (ArrayList<Tile> list : room) {
            for (Tile t : list) {
                if (t.getEntity() != null && t.getEntity().equals(entity)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<ArrayList<Tile>> getRoomList() {
        return Collections.unmodifiableList(room);
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
