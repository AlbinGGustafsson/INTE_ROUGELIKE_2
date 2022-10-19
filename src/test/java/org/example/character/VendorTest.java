package org.example.character;

import org.example.Race;
import org.example.VendorItem;
import org.example.characters.Player;
import org.example.characters.Vendor;
import org.example.world.Position;
import org.example.world.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class VendorTest {

    Vendor vendor;
    Player player;
    ByteArrayOutputStream output;
    PrintStream out;
    @BeforeEach
    void setUp(){

        World world = new World();

        VendorItem spade = new VendorItem("Spade", "Kan gräva", 10);
        VendorItem hammare = new VendorItem("Hammare", "Kan slå", 6);

        vendor = new Vendor("name", Race.GOBLIN, "TestDialog1.txt", new ArrayList<>(List.of(spade, hammare)));
        player = new Player("name", Race.HUMAN);

        world.getRoom(0).setEntity(vendor, new Position(5,6));
        world.getRoom(0).setEntity(player, new Position(5,7));

        output = new ByteArrayOutputStream();
        out = new PrintStream(output);
        vendor.setPrintStream(out);
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

        String input = "Y\nN\nN";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        vendor.setScanner(in);

        vendor.interact(player);
        for(int i = 0; i < vendor.getStock().size(); i++){
            assertThat(output.toString(), containsString(String.format("Buy %s? Yes:[Y] No: [N]", vendor.getStock().get(i))));
        }

    }

//    @Test
//    void playerBuysItem(){
//
//        String input = "Y\nN\nN";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        vendor.setScanner(in);
//
//        vendor.interact(player);
//        assertThat()
//    }

    @Test
    void playerDoesNotBuyItemWithInsufficientBalance(){

    }

    @Test
    void playerDoesNotBuyItemWithoutInventorySpace(){

    }
}