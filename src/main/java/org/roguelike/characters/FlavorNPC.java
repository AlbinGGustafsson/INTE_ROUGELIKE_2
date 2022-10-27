package org.roguelike.characters;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.roguelike.world.PrintFormatConstants;

public class FlavorNPC extends NPC {
    public FlavorNPC(String name, Race race, String filePath) {
        super(name, race, filePath);
    }


    public void interact(Player player){

        printDialogue();
    }


    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "N" + PrintFormatConstants.RESET;
    }

    @Override
    public Text getText() {

        Text text = new Text("N");
        text.setFill(Color.BLANCHEDALMOND);
        return text;
    }
}
