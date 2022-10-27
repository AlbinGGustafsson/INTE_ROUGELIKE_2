package org.roguelike.quest;

import java.util.ArrayList;
import java.util.Objects;

public class QuestLog extends ArrayList<Quest>{

    @Override
    public boolean add(Quest quest) {

        return super.add(Objects.requireNonNull(quest));
    }
}
