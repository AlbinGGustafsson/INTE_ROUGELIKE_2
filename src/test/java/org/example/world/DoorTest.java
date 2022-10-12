package org.example.world;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class DoorTest {

    //private static final Direction[] ALL_DIRECTIONS_NOT_LEFT_OR_RIGHT = {Direction.UP, Direction.UP_RIGHT, Direction.UP_LEFT, Direction.DOWN, Direction.DOWN_LEFT, Direction.DOWN_RIGHT};

    @Test
    void constructor_Accepts_Left_Direction(){
        Door door = new Door(Direction.LEFT);
        assertEquals("L", door.toString());
    }

    @Test
    void constructor_Accepts_Right_Direction(){
        Door door = new Door(Direction.RIGHT);
        assertEquals("R", door.toString());
    }

    @ParameterizedTest(name = "{index} int: {0}")
    @MethodSource("otherDoorDirections")
    void constructor_Not_Accepting_Other_Directions(Direction direction){
        assertThrows(IllegalArgumentException.class, () -> new Door(direction));
    }

    private static Stream<Direction> otherDoorDirections(){
        return Arrays.stream(Direction.class.getEnumConstants()).filter(dir -> !(dir.equals(Direction.LEFT) || dir.equals(Direction.RIGHT)));
        //return Arrays.stream(ALL_DIRECTIONS_NOT_LEFT_OR_RIGHT);
    }

    @Test
    void printWalkThrough_Prints_Correct(){

    }

}
