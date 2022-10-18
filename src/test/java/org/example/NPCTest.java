package org.example;

import org.example.characters.FlavorNPC;
import org.example.characters.NPC;
import org.example.characters.Player;
import org.example.world.Position;
import org.example.world.World;
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

        World world = new World();

        npc = new FlavorNPC("name", Race.ELF, "TestDialog1");
        player = new Player("name", Race.HUMAN);

        world.getRoom(0).setEntity(npc, new Position(5,6));
        world.getRoom(0).setEntity(player, new Position(5,7));

        output = new ByteArrayOutputStream();
        out = new PrintStream(output);
        npc.setPrintStream(out);
    }


    @Test
    void interactsWithPlayer(){

        assertThat(player.interactWithTile(npc.getRoom().getTile(npc.getPosition())), is(true));

    }
    @Test
    void interactionHasCorrectDialogue(){

        npc.interact(player);

        assertThat(npc.getParsedDialogue(), equalTo(output));

    }
}
