package org.example.world;

public class Door extends Terrain{

    private DoorDirection direction;
    public Door(DoorDirection direction) {
        this.direction = direction;
    }

    public DoorDirection getDirection() {
        return direction;
    }
    @Override
    public String toString() {
        return String.valueOf(direction.toString().charAt(0));
    }

}
