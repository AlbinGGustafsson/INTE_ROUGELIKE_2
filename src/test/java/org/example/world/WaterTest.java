package org.example.world;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaterTest {

    @Test
    void sets_typeName_Correct_For_Water() {
        Terrain t = new Water();
        assertEquals("water", t.getTypeName());
    }

    @Test
    void sets_weight_Correct_For_Water() {
        Terrain t = new Water();
        assertEquals(2, t.getWeight());
    }

    @Test
    void printNonReachableMessage_Prints_Correct_For_Water() {
        Terrain t = new Water();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        t.setPrintStream(out);
        t.printNonReachableMessage();
        String correctPrint = "You cant swim";
        assertEquals(correctPrint, output.toString().trim());
    }

    @Test
    void toString_Is_Correct_For_Water() {
        Terrain t = new Water();
        String correctString = PrintFormatConstants.BLUE + "W" + PrintFormatConstants.BOLD;
        assertEquals(correctString, t.toString());
    }
}
