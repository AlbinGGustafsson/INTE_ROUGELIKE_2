package org.example;

public class Helmet extends Armor{
    private static final int MAX_ARMOR_RATING = 300;

    public Helmet(String name, String description, int ilvl, int armorRating){

        super(name, description, ilvl, armorRating);
    }

    @Override
    protected void checkArmorRating(int armorRating) {
        if (armorRating > MAX_ARMOR_RATING){
            throw new IllegalArmorRatingException();
        }

    }

}
