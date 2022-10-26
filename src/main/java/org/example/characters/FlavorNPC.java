package org.example.characters;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.example.Race;
import org.example.world.PrintFormatConstants;
import org.example.world.Tile;

public class FlavorNPC extends NPC {
    public FlavorNPC(String name, Race race, String filePath) {
        super(name, race, filePath);
    }


    public void interact(Player player){

        printDialogue();
    }

    @Override
    protected boolean interactWithTile(Tile tile) {
        return false;
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "N" + PrintFormatConstants.RESET;
    }
    @Override
    public Text getText() {
        Text text = new Text("N");
        text.setFill(Color.GREEN);
        return text;
    }

}
