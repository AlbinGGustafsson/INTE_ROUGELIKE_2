package org.roguelike.world;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Stone extends Entity{

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.BLACK + "S" + PrintFormatConstants.RESET;
    }

    @Override
    public void printNonReachableMessage() {
        getPrintStream().println("There is a stone in the way");
    }


    @Override
    public Text getText() {
        Text text = new Text("S");
        text.setFill(Color.BLACK);
        return text;
    }

}
