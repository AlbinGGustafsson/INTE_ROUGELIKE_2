package org.roguelike.character;

import org.roguelike.characters.Race;
import org.roguelike.characters.FlavorNPC;
import org.roguelike.characters.NPC;
import org.roguelike.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.roguelike.world.Direction;
import org.roguelike.world.Position;
import org.roguelike.world.TestableRoomCreator;
import org.roguelike.world.World;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
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
    void nameSetCorrectly(){

        assertThat(npc.getName(), equalTo("name"));
    }

    @Test
    void raceSetCorrectly(){

        assertThat(npc.getRace(), equalTo(Race.ELF));
    }

    @Test
    void fileNameIsFound(){

        assertThat(npc.getDialogue(), is(notNullValue()));
    }
    @Test
    void interactionHasCorrectDialogue(){

        World world = new World(new TestableRoomCreator());

        world.getRoom(0).setEntity(player, new Position(1, 4));
        world.getRoom(0).setEntity(npc, new Position(2, 4));
        player.move(Direction.RIGHT);
        npc.setPrintStream(out);

        assertThat(output.toString().trim(), equalTo(npc.getParsedDialogue().trim()));

    }

    @Test
    void fileNotFoundThrowsException(){

        assertThat(()-> new FlavorNPC("namn", Race.HUMAN, "FelDialog.txt"), throwsException(RuntimeException.class));
    }
}
