package org.example;

public class Boots extends Armor{
    public Boots(String name, String description, int ilvl, int armorRating) {
        super(name, description, ilvl, armorRating);
    }

    @Override
    protected int getMaxArmorRating() {
        return 0;
    }


}
