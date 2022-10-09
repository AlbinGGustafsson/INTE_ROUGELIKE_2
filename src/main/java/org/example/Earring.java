package org.example;

public class Earring extends Accessory{
    private static final int MAX_PERCENT_DMG_INCREASE = 10;
    private static final int MAX_NUMBER_OF_SAME_TYPE_EQUIPS = 2;

    public Earring(String name, String description, int ilvl, int percentDmgIncrease) {
        super(name, description, ilvl, percentDmgIncrease);
    }

    @Override
    protected int getMaxRating() {
        return MAX_PERCENT_DMG_INCREASE;
    }

    @Override
    public int maxNumberOfSameTypeEquips() {
        return MAX_NUMBER_OF_SAME_TYPE_EQUIPS;
    }
}
