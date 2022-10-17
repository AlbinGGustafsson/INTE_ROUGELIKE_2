package org.example.characters;

import org.example.Race;
import org.example.world.PrintFormatConstants;

public class Vendor extends NPC {
    public Vendor(String name, Race race, String dialogueFilePath) {

        super(name, race, dialogueFilePath);
    }

    @Override
    protected void interact(Player player){

        printDialogue();
        if (dialogueOption("Do you want to browse shop? [Y]").equalsIgnoreCase("Y")) {
            openShop();
        }
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "V" + PrintFormatConstants.RESET;
    }

    private void openShop(){


    }
}
