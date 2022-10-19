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
    public void interact(Player player){

        printDialogue();
        if(availableQuest == null){
            return;
        }
        showDialogueOption("Do you want to pick up a quest? [Y]");
        if(!readPlayerInput().equalsIgnoreCase("Y")) {

            return;
        }
        player.getQuestLog().add(availableQuest);
        availableQuest = null;
    }

    @Override
    protected boolean interactWithTile(Tile tile) {
        return false;
    }

    void giveQuest(Player player){

        if(availableQuest != null && readPlayerInput().equalsIgnoreCase("Y")) {

            player.getQuestLog().add(availableQuest);
            availableQuest = null;
        }
    }


    public Quest getAvailableQuest() {
        return availableQuest;
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "Q" + PrintFormatConstants.RESET;
    }
}
