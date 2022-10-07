package org.example.world;

import java.util.Optional;

public class Aksel extends Entity implements NonStackable{

    private int x;
    private int y;
    private Room room;

    public Aksel(int x, int y, Room room) {
        this.x = x;
        this.y = y;
        this.room = room;
        room.addEntity(this, x, y);
    }

    public void remove(){
        room.getTile(x, y).removeEntity(this);
    }

    public void moveLeft(){
        Optional<Entity> entity = room.getTile(x - 1, y).getEntities().stream().filter(e -> e instanceof Door).findFirst();
        if (entity.isPresent()){
            System.out.println("DOOR!!!");
            Door door = (Door) entity.get();
            System.out.println(door.getDirection());
            return;
        }

        remove();

        x = x-1;
        room.addEntity(this,x, y);
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "A";
    }

}
