package org.example;

public class Chestpiece extends Armor {
    private static final int MAX_ARMOR_RATING = 400;

    public Chestpiece(String name, String description, int ilvl, int armorRating) {
        super(name, description, ilvl, armorRating);
    }

    @Override
    protected int getMaxArmorRating() {
        return MAX_ARMOR_RATING;
    }


}
