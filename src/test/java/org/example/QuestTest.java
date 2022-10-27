package org.example;

import org.example.characters.QuestGiver;
import org.junit.jupiter.api.Test;

import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class QuestTest {


    @Test
    void newQuestWithoutNameThrowsException(){

        assertThat(()-> new QuestGiver("name", Race.DWARF, "TestDialog3.txt", null), throwsException(NullPointerException.class));
    }
    @Test
    void newQuestWithoutDescriptionThrowsException(){

        assertThat(()-> new QuestGiver("name", Race.DWARF, "TestDialog3.txt", null), throwsException(NullPointerException.class));
    }
    @Test
    void newQuestWithNegativeXPRewardThrowsException(){

        assertThat(()-> new Quest("name", "desc", -1), throwsException(IllegalArgumentException.class));
    }

    @Test
    void newQuestHasFalseCompletion(){

        Quest quest = new Quest("name", "desc", 5);

        assertThat(quest.getCompletion(), is(false));
    }

    @Test
    void toStringIsFormattedCorrectly(){

        Quest quest = new Quest("name", "desc", 5);

        assertThat(quest.toString(), equalTo("[name, desc, 5]"));
    }

    @Test
    void completedQuestHasCorrectToString(){

        Quest quest = new Quest("name", "desc", 5);
        quest.setCompletion(true);

        assertThat(quest.toString(), equalTo("[name, desc, 5 (Completed)]"));
    }
}
