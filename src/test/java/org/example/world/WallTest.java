package org.example.world;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
    void getText_Wall_Returns_Text_Correct_Text(){
        Wall wall = new Wall();
        Text text = new Text("#");
        assertEquals(text.getText(), wall.getText().getText());
    }

    @Test
    void getText_Wall_Returns_Text_Correct_Color(){
        Wall wall = new Wall();
        assertEquals(Color.BLACK, wall.getText().getFill());
    }

    @Test
    void toString_Is_Correct_For_Floor() {
        Wall w = new Wall();
        String correctString = PrintFormatConstants.BOLD + PrintFormatConstants.BLACK + "#" + PrintFormatConstants.RESET;
        assertEquals(correctString, w.toString());
    }

}
