package org.example.characters;

import org.example.Race;
import org.example.world.PrintFormatConstants;

public class FlavorNPC extends NPC {
    public FlavorNPC(String name, Race race, String filePath) {
        super(name, race, filePath);
    }


    protected void interact(Player player){

        printDialogue();
    }
    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "N" + PrintFormatConstants.RESET;
    }
}
