package org.example;

import java.util.ArrayList;

public class QuestLog {

    private ArrayList<Quest> quests;

    public QuestLog() {
        quests = new ArrayList<>();
    }

    public void addQuest(Quest q){

        quests.add(q);
    }

    public void removeQuest(Quest q){

        quests.remove(q);
    }

    public String toString(){

        return quests.toString();
    }
}
