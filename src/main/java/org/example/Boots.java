package org.example;

public class Boots extends Armor{
    private static final int MAX_ARMOR_RATING = 200;

    public Boots(String name, String description, int ilvl, int armorRating) {
        super(name, description, ilvl, armorRating);
    }




    @Override
    protected int getMaxRating() {
        return MAX_ARMOR_RATING;
    }
}
