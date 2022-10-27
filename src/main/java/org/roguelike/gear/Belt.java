package org.roguelike.gear;

public class Belt extends Accessory {
    private static final int MAX_PERCENT_DMG_INCREASE = 15;

    public Belt(String name, String description, int ilvl, int percentDmgIncrease) {
        super(name, description, ilvl, percentDmgIncrease);
    }



    @Override
    protected int getMaxRating() {
        return MAX_PERCENT_DMG_INCREASE;
    }
}
