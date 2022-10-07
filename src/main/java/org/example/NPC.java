package org.example;

public abstract class NPC extends GameCharacter{

    private Boolean isVendor;
    private Boolean isQuestGiver;

    public NPC(String name, Race race){
        super(name, race);
    }

    void dialogue(){


    }
}
