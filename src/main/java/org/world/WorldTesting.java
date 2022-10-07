package org.world;

public class WorldTesting {

    public static void main(String[] args) {

//        Room room = new Room();
//        room.addEntity(new Stone(), 1,1);
//
//        System.out.println(room);

        World world = new World();
        System.out.println("World");
        System.out.println(world);

        Room room = world.getRoom(0,0);
        room.addEntity(new Stone(), 0, 0);
        room.addEntity(new Stone(), 1, 1);
        Aksel aksel = new Aksel(1, 4, room);

        System.out.println("Room 0, 0");
        System.out.println(room);

        aksel.moveLeft();


        System.out.println(room);

        Door door = (Door) room.getTile(4, 8).getEntities().get(0);

        System.out.println(door.getDirection());

    }

}
