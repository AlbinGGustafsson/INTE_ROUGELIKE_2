package org.example.world;

import java.util.ArrayList;

public class CorridorRoom extends Room{
    public CorridorRoom(ArrayList<ArrayList<Tile>> room, World world, int x, int y) {
        super(room, world, x, y);
    }

    @Override
    public String roomType() {
        return "C";
    }
}
