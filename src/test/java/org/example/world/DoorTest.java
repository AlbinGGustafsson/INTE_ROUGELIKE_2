package org.example.world;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class DoorTest {

    //private static final Direction[] ALL_DIRECTIONS_NOT_LEFT_OR_RIGHT = {Direction.UP, Direction.UP_RIGHT, Direction.UP_LEFT, Direction.DOWN, Direction.DOWN_LEFT, Direction.DOWN_RIGHT};
    private static final Direction[] ACCEPTED_DIRECTIONS = {Direction.LEFT, Direction.RIGHT};


    @Test
    void constructor_Accepts_Right_Direction(){
        Door door = new Door(Direction.RIGHT);
        assertEquals(Direction.RIGHT, door.getDirection());
    }

    @Test
    void constructor_Accepts_Left_Direction(){
        Door door = new Door(Direction.LEFT);
        assertEquals(Direction.LEFT, door.getDirection());
    }

    @ParameterizedTest(name = "{index} int: {0}")
    @MethodSource("otherDoorDirections")
    void constructor_Not_Accepting_Other_Directions(Direction direction){
        assertThrows(IllegalArgumentException.class, () -> new Door(direction));
    }

    @ParameterizedTest
    @MethodSource("acceptedDirections")
    void printWalkThrough_Prints_Correct(Direction direction){
        Door door = new Door(direction);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        door.setPrintStream(out);
        door.printWalkThrough();
        String correctPrint = "Walking through door " + direction.name();
        assertEquals(correctPrint, output.toString().trim());
    }

    @ParameterizedTest
    @MethodSource("acceptedDirections")
    void printNonReachableMessage_Prints_Correct(Direction direction){
        Door door = new Door(direction);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        door.setPrintStream(out);
        door.printNonReachableMessage();
        String correctPrint = "You cant walk through door " + direction.name();
        assertEquals(correctPrint, output.toString().trim());
    }

    @ParameterizedTest
    @MethodSource("acceptedDirections")
    void toString_Is_Correct(Direction direction){
        Door door = new Door(direction);
        assertEquals(direction.toString().substring(0,1), door.toString());
    }

    private static Stream<Direction> acceptedDirections(){
        return Arrays.stream(ACCEPTED_DIRECTIONS);
    }

    private static Stream<Direction> otherDoorDirections(){
        return Arrays.stream(Direction.class.getEnumConstants()).filter(dir -> !Arrays.asList(ACCEPTED_DIRECTIONS).contains(dir));
    }

    @Test
    void getText_Left_Door_returns_Text_Correct_Text(){
        Door door = new Door(Direction.LEFT);
        Text text = new Text("L");
        assertEquals(text.getText(), door.getText().getText());
    }

    @Test
    void getText_Right_Door_returns_Text_Correct_Text(){
        Door door = new Door(Direction.RIGHT);
        Text text = new Text("R");
        assertEquals(text.getText(), door.getText().getText());
    }

    @Test
    void getText_Right_Door_Returns_Text_Correct_Color(){
        Door door = new Door(Direction.RIGHT);
        assertEquals(Color.BROWN, door.getText().getFill());
    }

    @Test
    void getText_SLeft_Door_Returns_Text_Correct_Color(){
        Door door = new Door(Direction.LEFT);
        assertEquals(Color.BROWN, door.getText().getFill());
    }

}
