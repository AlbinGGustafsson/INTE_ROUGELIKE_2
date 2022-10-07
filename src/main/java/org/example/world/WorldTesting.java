package org.example.world;

public class WorldTesting {

    public static void main(String[] args) {

        Room room = new Room();
        room.addEntity(new Stone(), 1,1);

        System.out.println(room);
    }

}
