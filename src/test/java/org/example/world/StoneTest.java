package org.example.world;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoneTest {

    @Test
    void printNonReachableMessage_Prints_Correct() {
        Stone s = new Stone();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        s.setPrintStream(out);
        s.printNonReachableMessage();
        String correctPrint = "There is a stone in the way";
        assertEquals(correctPrint, output.toString().trim());
    }

    @Test
    void toString_Is_Correct_For_Floor() {
        Stone s = new Stone();
        String correctString = PrintFormatConstants.BOLD + PrintFormatConstants.BLACK + "S" + PrintFormatConstants.RESET;
        assertEquals(correctString, s.toString());
    }

}
