package org.example;

import org.example.world.PrintFormatConstants;
import org.example.world.Tile;

import java.util.Scanner;

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
        if(tile.getEntity() instanceof Player player){

            if(offerQuest()){

                player.getQuestLog().add(availableQuest);
                availableQuest = null;
            }
        }
        return false;
    }

    private boolean offerQuest(){

        Scanner scanner = new Scanner(System.in);

        getPrintStream().println("Do you want do accept my quest? Yes: [Y]");
        String command = scanner.nextLine();

        if(command.equalsIgnoreCase("Y")){

            return true;
        }
        return false;
    }
}
