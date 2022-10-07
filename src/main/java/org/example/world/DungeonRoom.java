package org.example.world;

import java.util.ArrayList;

public class DungeonRoom extends Room {
    public DungeonRoom(ArrayList<ArrayList<Tile>> room, World world, int x, int y) {
        super(room, world, x, y);
    }

    @Override
    public String roomType() {
        return "R";
    }
}
