package org.example.characters;

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
}
