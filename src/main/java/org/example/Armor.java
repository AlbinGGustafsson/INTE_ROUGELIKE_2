package org.example;

public abstract class Armor extends Gear{

    protected int armorRating;


    public Armor(String name, String description, int ilvl, int armorRating) {
        super(name, description, ilvl);
        if (!hasValidArmorRating(armorRating)) {
            throw new IllegalArmorRatingException();
        }
        this.armorRating = armorRating;
    }

    public int getArmorRating() {
        return armorRating;
    }

    private boolean hasValidArmorRating(int armorRating){
        return armorRating <= getMaxArmorRating() && armorRating >= 0;
    }

    protected abstract int getMaxArmorRating();


}
