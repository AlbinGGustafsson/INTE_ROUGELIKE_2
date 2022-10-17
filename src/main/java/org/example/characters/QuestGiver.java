package org.example.characters;

import org.example.Race;
import org.example.world.PrintFormatConstants;
import org.example.world.Tile;

public class QuestGiver extends NPC{

    private Quest availableQuest;
    public QuestGiver(String name, Race race, String filePath) {
        super(name, race, filePath);
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "Q" + PrintFormatConstants.RESET;
    }

    @Override
    protected boolean interactWithTile(Tile tile) {

        return false;
    }

    @Override
    protected void interact(Player player){

        printDialogue();
        if (dialogueOption("Do you want to pick up quest? [Y]").equalsIgnoreCase("Y")) {
            player.getQuestLog().add(availableQuest);
            availableQuest = null;
        }
    }
}
