package org.example.character;

import org.example.Race;
import org.example.characters.FlavorNPC;
import org.example.characters.NPC;
import org.example.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class NPCTest {

    NPC npc;
    Player player;
    ByteArrayOutputStream output;
    PrintStream out;


    @BeforeEach
    void setUp(){

        npc = new FlavorNPC("name", Race.ELF, "TestDialog1.txt");
        player = new Player("name", Race.HUMAN);

        output = new ByteArrayOutputStream();
        out = new PrintStream(output);
        npc.setPrintStream(out);
    }

    @Test
    void interactionHasCorrectDialogue(){

        npc.interact(player);

        assertThat(npc.getParsedDialogue().trim(), equalTo(output.toString().trim()));

    }
}
