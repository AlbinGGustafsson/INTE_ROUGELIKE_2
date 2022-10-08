package org.example;

public class Chestpiece extends Armor {
    public Chestpiece(String name, String description, int ilvl, int armorRating) {
        super(name, description, ilvl, armorRating);
    }

    @Override
    protected void checkArmorRating(int armorRating) {

    }
}
