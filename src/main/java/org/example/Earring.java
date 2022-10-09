package org.example;

public class Earring extends Accessory{
    private static final int MAX_PERCENT_DMG_INCREASE = 10;

    public Earring(String name, String description, int ilvl, int percentDmgIncrease) {
        super(name, description, ilvl, percentDmgIncrease);
    }

    @Override
    protected int getMaxRating() {
        return MAX_PERCENT_DMG_INCREASE;
    }
}
