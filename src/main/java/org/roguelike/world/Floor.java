package org.roguelike.world;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Floor extends Terrain{

    public Floor() {
        super("floor", 1);
    }

    @Override
    public String toString() {
        return "F";
    }

    @Override
    public void printNonReachableMessage() {
        getPrintStream().println("You cant go on floor");
    }

    @Override
    public Text getText() {
        Text text = new Text("F");
        text.setFill(Color.WHITE);
        return text;
    }
}
