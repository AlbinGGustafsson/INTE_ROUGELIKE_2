package org.example;

public class Necklace extends Accessory{

    private static final int MAX_PERCENT_DMG_INCREASE = 20;

    public Necklace(String name, String description, int ilvl, int percentDmgIncrease) {
        super(name, description, ilvl, percentDmgIncrease);
    }

    @Override
    protected int getMaxPercentDmgIncrease() {
        return MAX_PERCENT_DMG_INCREASE;
    }
}
