package org.example.characters;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.example.Race;
import org.example.world.Entity;

public abstract class GameCharacter extends Entity {
    private String name;
    private String lore;
    private Race race;

    public GameCharacter(String name, Race race) {
        this.name = name;
        this.race = race;
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
