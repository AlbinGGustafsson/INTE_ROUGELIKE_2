package org.example.world;

import java.util.ArrayList;

public class VoidRoom extends Room{
    public VoidRoom(ArrayList<ArrayList<Tile>> room, World world, int x, int y) {
        super(room, world, x, y);
    }


    @Override
    public void addNonStackableEntity(NonStackableEntity e, int x, int y) {
        System.out.println("Cant add entities to void room");
    }

    @Override
    public String roomType() {
        return "V";
    }
}
