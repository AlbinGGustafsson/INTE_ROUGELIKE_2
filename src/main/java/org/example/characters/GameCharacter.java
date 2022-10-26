package org.example.characters;

import org.example.Race;
import org.example.world.Entity;

import java.util.Objects;

public abstract class GameCharacter extends Entity {
    private final String name;
    private String lore;
    private final Race race;

    public GameCharacter(String name, Race race) {
        this.name = Objects.requireNonNull(name);
        this.race = Objects.requireNonNull(race);
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    @Override
    public void printNonReachableMessage() {
        System.out.println("Can't walk on character");
    }

}
