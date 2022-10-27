package org.roguelike.world;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Water extends Terrain {

    public Water() {
        super("water", 2);
    }
    @Override
    public String toString() {
        return PrintFormatConstants.BLUE + "W" + PrintFormatConstants.BOLD;
    }

    @Override
    public void printNonReachableMessage() {
        getPrintStream().println("You cant swim");
    }

    @Override
    public Text getText() {
        Text text = new Text("W");
        text.setFill(Color.BLUE);
        return text;
    }
}
