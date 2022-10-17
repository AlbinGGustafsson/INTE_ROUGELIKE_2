package org.example.world;

import java.io.OutputStream;
import java.io.PrintStream;

public class GamePrintStream extends PrintStream {

    private static StringBuilder gameText = new StringBuilder();

    public GamePrintStream() {
        super(System.out);
    }

    public void println(String str) {
        super.println(str);
        gameText.append(str + "\n");
    }


    public static String getGameText(){
        return gameText.toString();
    }

    public static void clearGameText(){
        gameText = new StringBuilder();
    }

}
