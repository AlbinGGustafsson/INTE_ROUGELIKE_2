package org.example;

import org.example.world.PrintFormatConstants;

public class QuestGiver extends NPC{
    public QuestGiver(String name, Race race, String filePath) {
        super(name, race, filePath);
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "Q" + PrintFormatConstants.RESET;
    }
}
