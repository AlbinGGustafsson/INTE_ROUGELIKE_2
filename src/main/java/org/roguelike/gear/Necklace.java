package org.roguelike.gear;

public class Necklace extends Accessory {

    private static final int MAX_PERCENT_DMG_INCREASE = 20;

    public Necklace(String name, String description, int ilvl, int percentDmgIncrease) {
        super(name, description, ilvl, percentDmgIncrease);
    }



    @Override
    protected int getMaxRating() {
        return MAX_PERCENT_DMG_INCREASE;
    }
}
