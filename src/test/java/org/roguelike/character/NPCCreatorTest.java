package org.roguelike.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.roguelike.characters.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NPCCreatorTest {

    private static final NPC GENERIC_NPC = new FlavorNPC("FiskarenRuterFem", Race.HUMAN, "TestDialog1.txt");
    NPCCreator npcCreator;

    @BeforeEach
    void setUp(){

        npcCreator = new NPCCreator();
        for(int i = 0;i < 4;i++){

            npcCreator.getVendor();
            npcCreator.getQuestGiver();
            npcCreator.getFlavorNPC();
        }
    }

    @Test
    void genericNPCIsPlacedWhenNoVendors(){

        NPC createdNPC = npcCreator.getVendor();
        assertThat(createdNPC, equalTo(GENERIC_NPC));
    }

    @Test
    void genericNPCIsPlacedWhenNoQuestgivers(){

        NPC createdNPC = npcCreator.getQuestGiver();
        assertThat(createdNPC, equalTo(GENERIC_NPC));
    }

    @Test
    void genericNPCIsPlacedWhenNoFlavorNPCs(){

        NPC createdNPC = npcCreator.getFlavorNPC();
        assertThat(createdNPC, equalTo(GENERIC_NPC));
    }
}
