package org.roguelike.world;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloorTest {

    @Test
    void sets_typeName_Correct() {
        Terrain floor = new Floor();
        assertEquals("floor", floor.getTypeName());
    }

    @Test
    void sets_weight_Correct() {
        Terrain floor = new Floor();
        assertEquals(1, floor.getWeight());
    }

    @Test
    void printNonReachableMessage_Prints_Correct() {
        Terrain floor = new Floor();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        floor.setPrintStream(out);
        floor.printNonReachableMessage();
        String correctPrint = "You cant go on floor";
        assertEquals(correctPrint, output.toString().trim());
    }
    @Test
    void getText_returns_Text_Correct_Text(){
        Terrain floor = new Floor();
        Text text = new Text("F");
        assertEquals(text.getText(), floor.getText().getText());
    }

    @Test
    void getText_Floor_Returns_Text_Correct_Color(){
        Terrain floor = new Floor();
        assertEquals(Color.WHITE, floor.getText().getFill());
    }

    @Test
    void toString_Is_Correct_For_Floor() {
        Terrain t = new Floor();
        String correctString = "F";
        assertEquals(correctString, t.toString());
    }

}
