package org.roguelike.world;

import javafx.scene.text.Text;

import java.io.PrintStream;

public abstract class Entity {

    private PrintStream out = new GamePrintStream();
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

    public Text getText(){
        return new Text("E");
    }

    public abstract void printNonReachableMessage();
}
