package org.example.world;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GamePrintStreamTest {

    @Test
    void println_Appends_Line_StringBuilder(){
        GamePrintStream.clearGameText();
        GamePrintStream gamePrintStream = new GamePrintStream();
        gamePrintStream.println("line");

        assertEquals("line\n", GamePrintStream.getGameText());
    }

    @Test
    void multiple_Println_Appends_Line_StringBuilder(){
        GamePrintStream.clearGameText();
        GamePrintStream gamePrintStream = new GamePrintStream();
        gamePrintStream.println("line1",false);
        gamePrintStream.println("line2",false);
        gamePrintStream.println("line3",false);

        assertEquals("line1\nline2\nline3\n", GamePrintStream.getGameText());
    }

    @Test
    void clearGameText_Clears_GameText(){
        GamePrintStream gamePrintStream = new GamePrintStream();
        gamePrintStream.println("line", false);
        GamePrintStream.clearGameText();
        assertEquals("", GamePrintStream.getGameText());
    }
}
