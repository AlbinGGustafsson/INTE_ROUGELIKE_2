package org.example;

public class Ring extends Accessory{
    private static final int MAX_PERCENT_DMG_INCREASE = 10;

    public Ring(String name, String description, int ilvl, int percentDmgIncrease) {
        super(name, description, ilvl, percentDmgIncrease);
    }

    @Override
    protected int getMaxPercentDmgIncrease() {
        return MAX_PERCENT_DMG_INCREASE;
    }
}
