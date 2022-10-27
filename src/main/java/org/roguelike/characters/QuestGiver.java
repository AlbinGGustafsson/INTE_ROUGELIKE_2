package org.roguelike.characters;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.roguelike.quest.Quest;
import org.roguelike.world.PrintFormatConstants;

import java.util.Objects;

public class QuestGiver extends NPC{

    private Quest availableQuest;
    public QuestGiver(String name, Race race, String dialogueFilePath, Quest quest) {

        super(name, race, dialogueFilePath);
        availableQuest = Objects.requireNonNull(quest);
    }

    @Override
    public void interact(Player player){

        printDialogue();
        if(availableQuest == null){
            return;
        }
        printDialogueOption("Do you want to pick up a quest? [Y]");
        if(!readPlayerInput().equalsIgnoreCase("Y")) {

            return;
        }
        player.getQuestLog().add(availableQuest);
        availableQuest = null;
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "Q" + PrintFormatConstants.RESET;
    }
    @Override
    public Text getText() {

        Text text = new Text("Q");
        text.setFill(Color.CORNSILK);
        return text;
    }
}
