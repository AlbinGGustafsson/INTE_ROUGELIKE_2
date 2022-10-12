package org.example.world;

public abstract class Entity {

    private Room room;
    private Position position;

    public Room getRoom() {
        return room;
    }

    public Position getPosition() {
        return position;
    }

    public void updateRoom(Room room) {
        if (room.containsEntity(this)){
            this.room = room;
        }
    }

    public void updatePosition(Position position, Room room) {
        if (room.getTile(position).getEntity().equals(this)){
            this.position = position;
        }
    }

    public abstract void printNonReachableMessage();
}
