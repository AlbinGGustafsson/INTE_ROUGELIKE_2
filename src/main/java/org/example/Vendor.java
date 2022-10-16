package org.example;

import org.example.world.PrintFormatConstants;

public class Vendor extends NPC {
    public Vendor(String name, Race race, String filePath) {
        super(name, race, filePath);
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "V" + PrintFormatConstants.RESET;
    }
}
