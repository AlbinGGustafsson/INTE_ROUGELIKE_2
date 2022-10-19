package org.example.characters;

import org.example.Race;
import org.example.VendorItem;
import org.example.world.PrintFormatConstants;
import org.example.world.Tile;

import java.util.ArrayList;
import java.util.Scanner;

public class Vendor extends NPC {

    private ArrayList<VendorItem> stock;
    public Vendor(String name, Race race, String dialogueFilePath, ArrayList<VendorItem> items) {

        super(name, race, dialogueFilePath);
        stock = items;
    }

    @Override
    public void interact(Player player){

        printDialogue();
        if (dialogueOption("Do you want to browse shop? [Y]").equalsIgnoreCase("Y")) {
            openShop(player);
        }
    }

    @Override
    protected boolean interactWithTile(Tile tile) {
        return false;
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "V" + PrintFormatConstants.RESET;
    }

    private void openShop(Player player){

        Scanner scanner = new Scanner(System.in);

        for(VendorItem i: stock){

            getPrintStream().println(String.format("Buy %s? Yes:[Y] No: [N]", i));
            String command = scanner.nextLine();

            if(command.equalsIgnoreCase("Y")){
                try{
                    player.getInventory().add(i);
                    player.getInventory().decreaseBalance(i.getValue());

                }catch(Exception e){
                    getPrintStream().println(e.getMessage());
                }
            }
        }
    }
}
