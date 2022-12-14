package org.roguelike.character;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.roguelike.inventory.Inventory;
import org.roguelike.characters.Race;
import org.roguelike.inventory.VendorItem;
import org.roguelike.characters.Player;
import org.roguelike.characters.Vendor;
import org.roguelike.world.PrintFormatConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class VendorTest {

    Vendor vendor;
    Player player;
    ByteArrayOutputStream output;
    PrintStream out;

    VendorItem hammare;
    VendorItem spade;
    @BeforeEach
    void setUp(){

        spade = new VendorItem("Spade", "Kan gräva", 10);
        hammare = new VendorItem("Hammare", "Kan slå", 6);

        vendor = new Vendor("name", Race.GOBLIN, "TestDialog3.txt", new ArrayList<>(List.of(hammare, spade)));
        player = new Player("name", Race.HUMAN);

        output = new ByteArrayOutputStream();
        out = new PrintStream(output);
        vendor.setPrintStream(out);
    }

    @Test
    void newVendorWithEmptyStockThrowsException(){

        assertThat(()-> new Vendor("name", Race.DWARF, "TestDialog3.txt", new ArrayList<>()), throwsException(IllegalStateException.class));
    }
    @Test
    void vendorOffersToSellItems(){

        String input = "N";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        vendor.setScanner(in);

        vendor.interact(player);
        assertThat(output.toString(), containsString("Do you want to browse shop? [Y]"));

    }

    @Test
    void confirmationOpensShop(){

        String input = "Y\nN\nN";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        vendor.setScanner(in);

        vendor.interact(player);
        assertThat(output.toString(), containsString(String.format("Buy %s? Yes:[Y] No: [N]", vendor.getStock().get(0))));
    }

    @Test
    void everyItemInStockIsOffered(){

        String input = "N\nN";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        vendor.setScanner(in);

        vendor.openShop(player);
        for(int i = 0; i < vendor.getStock().size(); i++){
            assertThat(output.toString(), containsString(String.format("Buy %s? Yes:[Y] No: [N]", vendor.getStock().get(i))));
        }

    }

    @Test
    void boughtItemIsPlacedInInventory(){

        String input = "Y\nY";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        vendor.setScanner(in);

        player.getInventory().increaseBalance(20);
        vendor.openShop(player);
        assertThat(player.getInventory().contains(spade), is(true));
    }

    @Test
    void buyingItemReducesBalance(){

        String input = "Y\nY";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        vendor.setScanner(in);

        player.getInventory().increaseBalance(20);
        vendor.openShop(player);
        assertThat(player.getInventory().getBalance(), is(20-16));
    }

    @Test
    void inventoryUnchangedWhenNotBuying(){

        String input = "N\nN";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        vendor.setScanner(in);

        Inventory startInventory = player.getInventory();

        vendor.openShop(player);
        assertThat(player.getInventory(), equalTo(startInventory));
    }

    @Test
    void balanceUnchangedWhenNotBuying(){

        String input = "N\nN";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        vendor.setScanner(in);

        int startBalance = player.getInventory().getBalance();

        vendor.openShop(player);
        assertThat(player.getInventory().getBalance(), equalTo(startBalance));
    }

    @Test
    void toStringFormattedCorrectly(){

        assertThat(vendor.toString(), equalTo(PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "V" + PrintFormatConstants.RESET));
    }

    @Test
    void getTextHasRightCharacter(){

        Text text = new Text("V");

        assertThat(vendor.getText().getText(), equalTo(text.getText()));
    }

    @Test
    void getTextHasRightColor(){

        Text text = new Text("V");
        text.setFill(Color.CADETBLUE);

        assertThat(vendor.getText().getFill(), equalTo(text.getFill()));
    }

    @Test
    void unableToBuyItemThrowsException(){

        String input = "Y\nY";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        vendor.setScanner(in);

        assertThat(()-> vendor.openShop(player), throwsException(IllegalStateException.class));
    }
}
