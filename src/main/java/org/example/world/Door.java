package org.example.world;

import java.util.ArrayList;
import java.util.Arrays;

public class Door implements NonStackableEntity{

    //public void printWalkthru();

    private Direction direction;

    private static final Direction[] acceptedEnums = {Direction.LEFT, Direction.RIGHT};

    public Door(Direction direction) {
        if (!Arrays.stream(acceptedEnums).anyMatch(d -> d.equals(direction))){
            throw new IllegalArgumentException();
        }
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return direction.toString().substring(0,1);
    }

    @Override
    public void printNonReachableMessage() {

    }
}
