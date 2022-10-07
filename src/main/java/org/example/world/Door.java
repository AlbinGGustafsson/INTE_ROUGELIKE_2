package org.example.world;

public class Door extends Terrain{

    private Direction direction;
    public Door(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "D";
    }

}
