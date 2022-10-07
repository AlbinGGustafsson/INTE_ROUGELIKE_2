package org.example;

public abstract class Armor extends Gear{
    protected int armorRating;


    public Armor(int ilvl, int armorRating) {
        super(ilvl);
        checkArmorRating(armorRating);
        this.armorRating = armorRating;
    }

    public int getArmorRating() {
        return armorRating;
    }

    protected abstract void checkArmorRating(int armorRating);


}
