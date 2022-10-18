package org.example;

import java.util.ArrayList;

public class QuestLog extends ArrayList<Quest>{

    @Override
    public boolean add(Quest quest){

        super.add(quest);
        return true;
    }

    public ArrayList<Quest> getQuests() {
        return this;
    }
}
