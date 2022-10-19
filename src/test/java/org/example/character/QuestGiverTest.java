package org.example.character;

import org.example.Quest;
import org.example.Race;
import org.example.characters.Player;
import org.example.characters.QuestGiver;
import org.example.world.Position;
import org.example.world.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class QuestGiverTest {

    QuestGiver questGiver;
    Player player;
    ByteArrayOutputStream output;
    PrintStream out;

    Quest quest;

    @BeforeEach
    void setUp(){

        World world = new World();

        quest = new Quest("Hitta nemo", "Simma runt lite", 5);

        questGiver = new QuestGiver("name", Race.DWARF, "TestDialog1.txt", quest);
        player = new Player("name", Race.HUMAN);

        output = new ByteArrayOutputStream();
        out = new PrintStream(output);
        questGiver.setPrintStream(out);

        world.getRoom(0).setEntity(questGiver, new Position(5,6));
        world.getRoom(0).setEntity(player, new Position(5,7));
    }

    @Test
    void questGiverOffersQuest(){

        String input = "Y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        questGiver.setScanner(in);

        questGiver.interact(player);
        assertThat(output.toString(), containsString("Do you want to pick up a quest? [Y]"));

    }

    @Test
    void acceptedQuestAddedToLog(){

        String input = "Y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        questGiver.setScanner(in);

        questGiver.interact(player);
        assertThat(player.getQuestLog().contains(quest), is(true));
    }


    @Test
    void acceptedQuestNotOfferedAgain(){

        String input = "Y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        questGiver.setScanner(in);

        questGiver.interact(player);
        output.reset();
        questGiver.interact(player);
        assertThat(output.toString().contains("Do you want to pick up a quest? [Y]"), is(false));
    }
}