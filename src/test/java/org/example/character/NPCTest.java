package org.example.character;

import org.example.Race;
import org.example.characters.FlavorNPC;
import org.example.characters.NPC;
import org.example.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void nameSetCorrectly(){

        assertThat(npc.getName(), equalTo("name"));
    }

    @Test
    void raceSetCorrectly(){

        assertThat(npc.getRace(), equalTo(Race.ELF));
    }

    @Test
    void fileNameIsFound(){

        assertThat(npc.getDialogue(), notNullValue());
    }
    @Test
    void interactionHasCorrectDialogue(){

        npc.interact(player);

        assertThat(npc.getParsedDialogue().trim(), equalTo(output.toString().trim()));

    }

    @Test
    void fileNotFoundThrowsException(){

        assertThrows(RuntimeException.class, () -> new FlavorNPC("namn", Race.HUMAN, "FelDialog.txt"));

    }
}
