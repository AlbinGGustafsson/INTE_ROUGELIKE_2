package org.example.world;

import java.util.Arrays;

public class Door extends Entity {

    private Position position;

    private Direction direction;

    private static final Direction[] acceptedDirections = {Direction.LEFT, Direction.RIGHT};

    public Door(Direction direction) {
        if (Arrays.stream(acceptedDirections).noneMatch(d -> d.equals(direction))){
            throw new IllegalArgumentException();
        }
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void printWalkThrough(){
        System.out.println("Walking through door " + direction.name());
    }

    @Override
    public String toString() {
        return direction.toString().substring(0,1);
    }

    @Override
    public void printNonReachableMessage() {

    }
}
