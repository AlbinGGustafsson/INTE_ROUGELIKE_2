package org.example.character;

import org.example.Quest;
import org.example.Race;
import org.example.characters.Player;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QuestLogTest {

    @Test
    void acceptedQuestAddedToLog(){

        Player player = new Player("name", Race.GOBLIN);
        Quest quest = new Quest("name", "desc", 10);
        player.getQuestLog().add(quest);

        assertThat(player.getQuestLog().contains(quest), is(true));
    }
}
