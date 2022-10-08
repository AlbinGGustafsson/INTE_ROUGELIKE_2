package org.example;

public abstract class Armor extends Gear implements ArmorRatingScaling{
    private static final int MIN_ARMOR_RATING = 0;
    protected int armorRating;


    public Armor(String name, String description, int ilvl, int armorRating) {
        super(name, description, ilvl);
        if (hasValidRating(armorRating, getMaxArmorRating(), MIN_ARMOR_RATING)) {
            throw new IllegalArmorRatingException();
        }
        this.armorRating = armorRating;
    }

    public int getArmorRating() {
        return armorRating;
    }


    protected abstract int getMaxArmorRating();


}
