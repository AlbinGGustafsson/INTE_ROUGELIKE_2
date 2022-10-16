package org.example;

import org.example.world.PrintFormatConstants;

public class FlavorNPC extends NPC {
    public FlavorNPC(String name, Race race, String filePath) {
        super(name, race, filePath);
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "N" + PrintFormatConstants.RESET;
    }
}
