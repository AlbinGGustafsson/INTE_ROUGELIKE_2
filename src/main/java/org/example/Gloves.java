package org.example;

public class Gloves extends Armor{
    public Gloves(String name, String description, int ilvl, int armorRating) {
        super(name, description, ilvl, armorRating);
    }

    @Override
    protected int getMaxArmorRating() {
        return 0;
    }


}
