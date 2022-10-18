package org.example;

import org.example.characters.Player;
import org.example.characters.QuestGiver;
import org.example.world.Position;
import org.example.world.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class QuestGiverTest {

    QuestGiver questGiver;
    Player player;
    ByteArrayOutputStream output;
    PrintStream out;

    @BeforeEach
    void setUp(){

        World world = new World();

        Quest quest = new Quest("Hitta nemo", "Simma runt lite", 5);

        questGiver = new QuestGiver("name", Race.ELF, "TestDialog1", quest);
        player = new Player("name", Race.HUMAN);

        world.getRoom(0).setEntity(questGiver, new Position(5,6));
        world.getRoom(0).setEntity(player, new Position(5,7));

        output = new ByteArrayOutputStream();
        out = new PrintStream(output);
        questGiver.setPrintStream(out);
    }

    @Test
    void questGiverOffersQuest(){

        questGiver.interact(player);
        assertThat(output.toString(), containsString("Do you want to pick up a quest? [Y]"));

    }

    @Test
    void acceptedQuestAddedToLog(){

        questGiver.interact(player);
        if(questGiver.dialogueOption("Do you want to pick up a quest? [Y]").equalsIgnoreCase("Y"))
            assertThat(player.getQuestLog().contains(questGiver.getAvailableQuest()), is(true));
    }


    @Test
    void acceptedQuestNotOfferedAgain(){

        questGiver.interact(player);
        if(questGiver.dialogueOption("Do you want to pick up a quest? [Y]").equalsIgnoreCase("Y"))
            assertThat(output.toString().contains("Do you want to pick up a quest? [Y]"), is(false));
    }
}
