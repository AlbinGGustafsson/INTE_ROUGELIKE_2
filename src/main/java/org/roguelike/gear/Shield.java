package org.roguelike.gear;

public class Shield extends SubWeapon implements ArmorRatingScaling {

    public Shield(String name, String description, int ilvl, int rating) {
        super(name, description, ilvl, rating);
    }

    @Override
    protected boolean instanceOfMatchingWeapons(Equipable equipable) {
        return equipable instanceof Sword || equipable instanceof Wand;
    }

    @Override
    protected void throwException() {
        throw new IllegalArmorRatingException();
    }

    @Override
    public int getArmorRating() {
        return rating;
    }


}
