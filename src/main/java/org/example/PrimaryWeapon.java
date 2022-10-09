package org.example;

public abstract class PrimaryWeapon extends Weapon{
    protected static final int MAX_RATING = 1000;
    protected static final int MIN_RATING = 10;
    public PrimaryWeapon(String name, String description, int ilvl, int rating) {
        super(name, description, ilvl, rating);
    }

    @Override
    protected int getMaxRating() {
        return MAX_RATING;
    }

    @Override
    protected int getMinRating() {
        return MIN_RATING;
    }

    @Override
    protected boolean instanceOfOppositeWeapon(Equipable equipable) {
        return equipable instanceof SubWeapon;
    }
}
