package org.roguelike.character;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.roguelike.characters.Race;
import org.roguelike.characters.FlavorNPC;
import org.roguelike.characters.Player;
import org.roguelike.world.PrintFormatConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FlavorNPCTest {

    FlavorNPC flavorNPC;
    Player player;
    ByteArrayOutputStream output;
    PrintStream out;

    @BeforeEach
    void setUp(){

        flavorNPC = new FlavorNPC("name", Race.GOBLIN, "TestDialog3.txt");
        player = new Player("name", Race.HUMAN);

        output = new ByteArrayOutputStream();
        out = new PrintStream(output);
        flavorNPC.setPrintStream(out);
    }

    @Test
    void toStringFormattedCorrectly(){

        assertThat(flavorNPC.toString(), equalTo(PrintFormatConstants.BOLD + PrintFormatConstants.CYAN + "N" + PrintFormatConstants.RESET));
    }

    @Test
    void getTextHasRightCharacter(){

        Text text = new Text("N");

        assertThat(flavorNPC.getText().getText(), equalTo(text.getText()));
    }

    @Test
    void getTextHasRightColor(){

        Text text = new Text("N");
        text.setFill(Color.BLANCHEDALMOND);

        assertThat(flavorNPC.getText().getFill(), equalTo(text.getFill()));
    }
}
