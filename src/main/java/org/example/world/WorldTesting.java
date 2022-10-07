package org.example.world;

public class WorldTesting {

    public static void main(String[] args) {

//        World world = new World();
//        System.out.println("World");
//        System.out.println(world);
//
//        Room room = world.getRoom(0,0);
//        room.addEntity(new Stone(), 0, 0);
//        room.addEntity(new Stone(), 1, 1);
//        Aksel aksel = new Aksel(1, 4, room);
//
//        System.out.println("Room 0, 0");
//        System.out.println(room);
//
//        aksel.moveLeft();
//
//
//        System.out.println(room);
//
//        Door door = (Door) room.getTile(4, 8).getEntities().get(0);
//
//        System.out.println(door.getDirection());

        World world = new World();
        System.out.println(world.toString());

        Room room = world.getRoom(1,1);
        //room.addNonStackableEntity(new Stone(), 0, 0);
        room.addNonStackableEntity(new Stone(), 1, 1);
        room.removeNonStackableEntity(1,1);
        room.addNonStackableEntity(new Stone(), 1, 1);

        PlayerExample aksel = new PlayerExample(2,1, room);
        System.out.println(world.getRoom(1,1));
        aksel.moveLeft();
        aksel.moveRight();
        aksel.moveRight();
        aksel.moveUp();

        System.out.println(world.getRoom(1,0));

        aksel.moveDown();

        System.out.println(world.getRoom(1,1));

        aksel.moveDown();
        aksel.moveDown();
        aksel.moveDown();
        aksel.moveDown();
        aksel.moveDown();
        aksel.moveDown();
        aksel.moveDown();

        System.out.println(world.getRoom(1,2));

        aksel.moveDown();
        aksel.moveDown();
        aksel.moveDown();
        aksel.moveLeft();
        aksel.moveLeft();
        aksel.moveLeft();
        aksel.moveLeft();

        System.out.println(world.getRoom(0,2));

        aksel.moveRight();

        System.out.println(world.getRoom(1,2));

        aksel.moveRight();
        aksel.moveRight();
        aksel.moveRight();
        aksel.moveRight();
        aksel.moveRight();
        aksel.moveRight();
        aksel.moveRight();

        System.out.println(world.getRoom(2,2));

        aksel.moveLeft();
        aksel.moveLeft();
        aksel.moveLeft();
        aksel.moveLeft();
        aksel.moveLeft();
        aksel.moveLeft();
        aksel.moveLeft();
        aksel.moveLeft();
        aksel.moveLeft();
        aksel.moveLeft();

        System.out.println(world.getRoom(0,2));
        aksel.moveLeft();
        aksel.moveLeft();
        aksel.moveLeft();
        aksel.moveLeft();
        System.out.println(world.getRoom(0,2));
        aksel.moveLeft();

    }

}
