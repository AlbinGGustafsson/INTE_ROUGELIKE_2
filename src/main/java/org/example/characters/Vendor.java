package org.example.characters;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.example.Race;
import org.example.VendorItem;
import org.example.world.PrintFormatConstants;

import java.util.ArrayList;

public class Vendor extends NPC {

    private final ArrayList<VendorItem> stock;
    public Vendor(String name, Race race, String dialogueFilePath, ArrayList<VendorItem> items) {

        super(name, race, dialogueFilePath);
        stock = items;
    }

    @Override
    public void interact(Player player){

        printDialogue();
        printDialogueOption("Do you want to browse shop? [Y]");
        if (!readPlayerInput().equalsIgnoreCase("Y")) {
            return;
        }
        openShop(player);
    }


    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "V" + PrintFormatConstants.RESET;
    }

    @Override
    public Text getText() {

        Text text = new Text("V");
        text.setFill(Color.CADETBLUE);
        return text;
    }

    public void openShop(Player player){

        for(VendorItem i: stock){

            printDialogueOption(String.format("Buy %s? Yes:[Y] No: [N]", i));

            if(readPlayerInput().equalsIgnoreCase("Y")){

                player.addToInventory(i);
                player.getInventory().decreaseBalance(i.getValue());
            }
        }
    }

//    private void sellItem(VendorItem i){
//
//        player.addToInventory(i);
//        player.getInventory().decreaseBalance(i.getValue());
//    }

    public ArrayList<VendorItem> getStock() {
        return stock;
    }
}
