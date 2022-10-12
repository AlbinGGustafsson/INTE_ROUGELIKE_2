package org.example.world;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {

    @Test
    void printNonReachableMessage_Prints_Correct() {
        Wall w = new Wall();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        w.setPrintStream(out);
        w.printNonReachableMessage();
        String correctPrint = "There is a wall in the way";
        assertEquals(correctPrint, output.toString().trim());
    }

    @Test
    void toString_Is_Correct_For_Floor() {
        Wall w = new Wall();
        String correctString = PrintFormatConstants.BOLD + PrintFormatConstants.BLACK + "#" + PrintFormatConstants.RESET;
        assertEquals(correctString, w.toString());
    }

}
