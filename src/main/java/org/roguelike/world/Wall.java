package org.roguelike.world;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Wall extends Entity {

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.BLACK + "#" + PrintFormatConstants.RESET;
    }

    @Override
    public void printNonReachableMessage() {
        getPrintStream().println("There is a wall in the way");
    }


    @Override
    public Text getText() {
        Text text = new Text("#");
        text.setFill(Color.BLACK);
        return text;
    }

}
