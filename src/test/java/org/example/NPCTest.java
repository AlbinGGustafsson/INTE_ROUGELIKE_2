package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NPCTest {


    @Test
    void canHaveNoOccupation(){

        NPC albin = new NPC("Albin", Race.HUMAN);
        assertEquals(null, albin.getOccupation());
    }

    @Test
    void canHaveOccupation(){

        NPC albin = new NPC("Albin", Race.HUMAN, Occupation.VENDOR);
        assertEquals(Occupation.VENDOR, albin.getOccupation());
    }

    @Test
    void hasDialogue(){

        NPC albin = new NPC("Albin", Race.HUMAN);
        assertNotNull(albin.dialogue());
    }

    @Test
    void questGiverOffersQuest(){

        NPC jonas = new NPC("Jonas", Race.ORC, Occupation.QUESTGIVER);
        String confirmPrompt = "Accept: 1" + "\n" + "Decline: 2";
        assertEquals(confirmPrompt, jonas.offerQuest());

    }

    @Test
    void completedQuestGivesReward(){

    }

    @Test
    void acceptedQuestNotOfferedAgain(){

    }

    @Test
    void vendorOpensShop(){

    }

}
