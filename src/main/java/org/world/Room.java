package org.world;

import java.util.ArrayList;

public class Room {

    private int roomHeight = 9;
    private int roomWidth = 9;
    private int horizontalDoorPlacement = roomHeight / 2;
    private int verticalDoorPlacement = roomWidth / 2;

    ArrayList<ArrayList<Tile>> room = new ArrayList<>();

    public Room() {
        for (int i = 0; i < roomHeight; i++) {
            ArrayList<Tile> row = new ArrayList();
            room.add(row);
            for (int j = 0; j < roomWidth; j++) {
                if (i == 0 || i == roomHeight - 1 || j == 0 || j == roomWidth - 1) {
                    if (i == horizontalDoorPlacement || j == verticalDoorPlacement) {
                        Tile tile = new Tile(new Grass());
                        row.add(tile);
                        tile.addEntity(new Door(this, j, i));
                    } else {
                        row.add(new Tile(new Wall()));
                    }
                } else {
                    row.add(new Tile(new Grass()));
                }
            }
        }
    }

    public void addEntity(Entity entity, int x, int y) {
        Tile tile = room.get(y).get(x);

        if (tile.canAddEntity()) {
            tile.addEntity(entity);
        } else {
            //System.out.println("Cant add other entity");
        }

    }

    public Tile getTile(int x, int y) {
        return room.get(y).get(x);
    }

    public int getRoomHeight() {
        return roomHeight;
    }

    public int getRoomWidth() {
        return roomWidth;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var row : room) {
            sb.append(row + "\n");
        }
        return sb.toString();
    }

    public String roomType() {
        return "R";
    }

}
