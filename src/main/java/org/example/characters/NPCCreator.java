package org.example.characters;

import org.example.Quest;
import org.example.Race;
import org.example.VendorItem;

import java.util.ArrayList;

public class NPCCreator {

    private static final NPC GENERIC_NPC = new FlavorNPC("FiskarenRuterFem", Race.HUMAN, "TestDialog1.txt");
    private ArrayList<QuestGiver> questGivers = new ArrayList<>();
    private ArrayList<Vendor> vendors = new ArrayList<>();
    private ArrayList<FlavorNPC> flavorNPCs = new ArrayList<>();

    public NPCCreator() {
        createVendors();
        createQuestGivers();
        createFlavorNPCs();
    }

    public NPC getQuestGiver() {
        if (questGivers.isEmpty()) {
            return GENERIC_NPC;
        }
        QuestGiver questGiver = questGivers.get(0);
        questGivers.remove(0);
        return questGiver;
    }

    public NPC getVendor() {
        if (vendors.isEmpty()) {
            return GENERIC_NPC;
        }
        Vendor vendor = vendors.get(0);
        vendors.remove(0);
        return vendor;
    }

    public NPC getFlavorNPC() {
        if (flavorNPCs.isEmpty()) {
            return GENERIC_NPC;
        }
        FlavorNPC flavorNPC = flavorNPCs.get(0);
        flavorNPCs.remove(0);
        return flavorNPC;
    }

    private void createFlavorNPCs() {
        flavorNPCs.add(new FlavorNPC("Jonas", Race.HUMAN, "TestDialog1.txt"));
        flavorNPCs.add(new FlavorNPC("Albin", Race.HUMAN, "TestDialog1.txt"));
        flavorNPCs.add(new FlavorNPC("Eloy", Race.HUMAN, "TestDialog1.txt"));
        flavorNPCs.add(new FlavorNPC("Petter", Race.HUMAN, "TestDialog1.txt"));
    }

    private void createQuestGivers() {
        questGivers.add(new QuestGiver("Janne", Race.GOBLIN, "TestDialog2.txt", new Quest("quest1", "desc", 1)));
        questGivers.add(new QuestGiver("Oboy", Race.GOBLIN, "TestDialog2.txt", new Quest("quest1", "desc", 1)));
        questGivers.add(new QuestGiver("Petrovich", Race.GOBLIN, "TestDialog2.txt", new Quest("quest1", "desc", 1)));
        questGivers.add(new QuestGiver("Abbe", Race.GOBLIN, "TestDialog2.txt", new Quest("quest1", "desc", 1)));
    }

    private void createVendors() {
        ArrayList<VendorItem> stock = new ArrayList<>();

        vendors.add(new Vendor("Gucci", Race.ELF, "TestDialog3.txt", stock));
        vendors.add(new Vendor("Baloo", Race.ELF, "TestDialog3.txt", stock));
        vendors.add(new Vendor("Footbar", Race.ELF, "TestDialog3.txt", stock));
        vendors.add(new Vendor("Krutong", Race.ELF, "TestDialog3.txt", stock));
    }

}

