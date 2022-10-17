package org.example;

import org.example.characters.Quest;

import java.util.ArrayList;

public class QuestLog extends ArrayList<Quest>{

    @Override
    public boolean add(Quest quest){

        super.add(quest);
        return true;
    }

    public void remove(Quest quest){

        super.remove(quest);
    }

    public ArrayList<Quest> getQuests() {
        return this;
    }
}
