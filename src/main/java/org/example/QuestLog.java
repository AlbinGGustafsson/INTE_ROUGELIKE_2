package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class QuestLog extends ArrayList<Quest>{

    @Override
    public boolean add(Quest quest){

        super.add(Objects.requireNonNull(quest));
        return true;
    }

    public ArrayList<Quest> getQuests() {
        return this;
    }
}
