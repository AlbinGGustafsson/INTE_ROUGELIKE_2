package org.example.world;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloorTest {

    @Test
    void sets_typeName_Correct() {
        Terrain t = new Floor();
        assertEquals("floor", t.getTypeName());
    }

    @Test
    void sets_weight_Correct() {
        Terrain t = new Floor();
        assertEquals(1, t.getWeight());
    }

    @Test
    void printNonReachableMessage_Prints_Correct() {
        Terrain t = new Floor();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        t.setPrintStream(out);
        t.printNonReachableMessage();
        String correctPrint = "You cant go on floor";
        assertEquals(correctPrint, output.toString().trim());
    }

    @Test
    void toString_Is_Correct_For_Floor() {
        Terrain t = new Floor();
        String correctString = "F";
        assertEquals(correctString, t.toString());
    }

}
