package org.example;

import org.example.world.Entity;

public abstract class GameCharacter extends Entity {
    String name;
    String lore;
    Race race;

    public GameCharacter(String name, Race race) {
    }

    @Override
    public void printNonReachableMessage() {
        System.out.println("Can't walk on character");
    }
}
