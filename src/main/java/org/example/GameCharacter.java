package org.example;

import org.example.world.NonStackableEntity;
import org.example.world.Room;

public abstract class GameCharacter implements NonStackableEntity {
    String name;
    String lore;
    Race race;

    private int XPos, YPos;
    private Room room;
    public GameCharacter(String name, Race race) {
    }

    public int getXPos() {
        return XPos;
    }

    public int getYPos() {
        return YPos;
    }

    public Room getRoom() {
        return room;
    }

    public void setXPos(int XPos) {
        this.XPos = XPos;
    }

    public void setYPos(int YPos) {
        this.YPos = YPos;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
