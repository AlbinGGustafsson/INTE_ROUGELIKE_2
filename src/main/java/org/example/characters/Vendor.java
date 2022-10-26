package org.example.characters;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.example.Race;
import org.example.VendorItem;
import org.example.world.PrintFormatConstants;
import org.example.world.Tile;

import java.util.ArrayList;

public class Vendor extends NPC {

    private ArrayList<VendorItem> stock;
    public Vendor(String name, Race race, String dialogueFilePath, ArrayList<VendorItem> items) {

        super(name, race, dialogueFilePath);
        stock = items;
    }

    @Override
    public void interact(Player player){

        printDialogue();
        showDialogueOption("Do you want to browse shop? [Y]");
        if (!readPlayerInput().equalsIgnoreCase("Y")) {
            return;
        }
        openShop(player);
    }

    @Override
    protected boolean interactWithTile(Tile tile) {
        return false;
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "V" + PrintFormatConstants.RESET;
    }

    public void openShop(Player player){

        for(VendorItem i: stock){

            showDialogueOption(String.format("Buy %s? Yes:[Y] No: [N]", i));

            if(readPlayerInput().equalsIgnoreCase("Y")){
                try{
                    player.getInventory().add(i);
                    player.getInventory().decreaseBalance(i.getValue());

                }catch(Exception e){
                    getPrintStream().println(e.getMessage());
                }
            }
        }
    }

    public ArrayList<VendorItem> getStock() {
        return stock;
    }

    @Override
    public Text getText() {
        Text text = new Text("V");
        text.setFill(Color.GOLD);
        return text;
    }

}
