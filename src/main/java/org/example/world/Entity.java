package org.example.world;

import java.io.PrintStream;

public abstract class Entity {

    //TDD gjorde så att jag insåg att det underlättar om Entity är en superklass istället för ett interface.
    //Den har en metod så man kan byta ut en printstream så att det går att testa.
    //Alla subklasser har utskrifter så det är najs att ha den metoden i en superklass
    private static PrintStream out = System.out;
    private Room room;
    private Position position;

    public Room getRoom() {
        return room;
    }

    public Position getPosition() {
        return position;
    }

    public void updateRoom(Room room) {
        if (room == null){
            this.room = null;
            this.position = null;
            return;
        }

        if (room.contains(this)){
            this.room = room;
        }
    }

    public void updatePosition(Position position, Room room) {

        try{
            if (room.getTile(position).getEntity().equals(this)){
                this.position = position;
            }
        }catch (NullPointerException e){}
    }


    public void setPrintStream(PrintStream out){
        this.out = out;
    }

    public PrintStream getPrintStream() {
        return out;
    }

    public abstract void printNonReachableMessage();
}
