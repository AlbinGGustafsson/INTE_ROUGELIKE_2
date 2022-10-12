package org.example.world;

import java.util.Arrays;

public class Door extends Entity {

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
        getOut().println("Walking through door " + direction.name());
    }

    @Override
    public String toString() {
        return direction.toString().substring(0,1);
    }

    @Override
    public void printNonReachableMessage() {
        getOut().println("You cant walk through door " + direction.name());
    }
}
