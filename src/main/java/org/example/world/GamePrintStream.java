package org.example.world;

import java.io.OutputStream;
import java.io.PrintStream;

public class GamePrintStream extends PrintStream {

    private static StringBuilder gameText = new StringBuilder();

    public GamePrintStream() {
        super(System.out);
    }
    @Override
    public void println(String str) {
        println(str, true);
    }

    public void println(String str, boolean printToSystemOut) {
        if (printToSystemOut){
            super.println(str);
        }
        gameText.append(str).append("\n");
    }


    public static String getGameText(){
        return gameText.toString();
    }

    public static void clearGameText(){
        gameText = new StringBuilder();
    }

}
