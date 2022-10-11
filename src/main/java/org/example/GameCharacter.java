package org.example;

import org.example.world.Entity;
import org.example.world.Position;
import org.example.world.Room;

public abstract class GameCharacter implements Entity {
    String name;
    String lore;
    Race race;

    private Position position;
    private Room room;
    public GameCharacter(String name, Race race) {
    }


    public Position getPosition() {
        return position;
    }

    public Room getRoom() {
        return room;
    }

    public void setPos(int x, int y){
        position = new Position(x,y);
    }

    public void setPos(Position position){
        this.position = position;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public void printNonReachableMessage() {
        System.out.println("Can't walk on character");
    }
}
