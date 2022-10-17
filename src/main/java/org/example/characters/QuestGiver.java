package org.example.characters;

import org.example.Quest;
import org.example.Race;
import org.example.world.PrintFormatConstants;
import org.example.world.Tile;

public class QuestGiver extends NPC{

    private Quest availableQuest;
    public QuestGiver(String name, Race race, String dialogueFilePath, Quest quest) {

        super(name, race, dialogueFilePath);
        availableQuest = quest;
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
        if(availableQuest != null && dialogueOption("Do you want to pick up quest? [Y]").equalsIgnoreCase("Y")) {

            player.getQuestLog().add(availableQuest);
            availableQuest = null;
        }
    }
}
