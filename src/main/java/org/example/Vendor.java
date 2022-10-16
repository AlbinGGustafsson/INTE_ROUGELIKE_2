package org.example;

import org.example.world.PrintFormatConstants;

public class Vendor extends NPC {
    public Vendor(String name, Race race, String filePath) {
        super(name, race, filePath);
    }

    @Override
    void interact(Player player){

        printDialogue();
        if ("Y".equalsIgnoreCase(dialogueOption("Do you want to browse shop? [Y]"))) {
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
