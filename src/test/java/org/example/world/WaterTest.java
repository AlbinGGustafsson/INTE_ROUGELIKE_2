package org.example.world;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaterTest {

    @Test
    void sets_typeName_Correct_For_Water() {
        Terrain water = new Water();
        assertEquals("water", water.getTypeName());
    }

    @Test
    void sets_weight_Correct_For_Water() {
        Terrain water = new Water();
        assertEquals(2, water.getWeight());
    }

    @Test
    void printNonReachableMessage_Prints_Correct_For_Water() {
        Terrain water = new Water();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        water.setPrintStream(out);
        water.printNonReachableMessage();
        String correctPrint = "You cant swim";
        assertEquals(correctPrint, output.toString().trim());
    }

    @Test
    void toString_Is_Correct_For_Water() {
        Terrain water = new Water();
        String correctString = PrintFormatConstants.BLUE + "W" + PrintFormatConstants.BOLD;
        assertEquals(correctString, water.toString());
    }

    @Test
    void getText_returns_Text_Correct_Text(){
        Terrain water = new Water();
        Text text = new Text("W");
        assertEquals(text.getText(), water.getText().getText());
    }

    @Test
    void getText_Water_Returns_Text_Correct_Color(){
        Terrain water = new Water();
        assertEquals(Color.BLUE, water.getText().getFill());
    }


}
