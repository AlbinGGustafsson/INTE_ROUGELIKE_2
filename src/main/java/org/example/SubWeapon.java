package org.example;

public abstract class SubWeapon extends Weapon {
    private static final int MAX_RATING = 400;
    private static final int MIN_RATING = 5;

    public SubWeapon(String name, String description, int ilvl, int rating) {
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
        return equipable instanceof PrimaryWeapon;
    }
}
