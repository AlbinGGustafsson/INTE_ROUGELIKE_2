package org.example;

import org.example.world.NonStackableEntity;

public abstract class GameCharacter implements NonStackableEntity {
    String name;
    String lore;
    Race race;

    public GameCharacter(String name, Race race) {
    }
}
