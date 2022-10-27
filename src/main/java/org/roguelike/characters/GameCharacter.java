package org.roguelike.characters;

import org.roguelike.world.Entity;

import java.util.Objects;

public abstract class GameCharacter extends Entity {
    private final String name;
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


    @Override
    public void printNonReachableMessage() {
        getPrintStream().println("Can't walk on character");
    }

}
