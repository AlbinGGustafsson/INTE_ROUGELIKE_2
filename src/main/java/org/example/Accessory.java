package org.example;

public abstract class Accessory extends Gear implements PercentDmgScaling{
    private static final int MIN_PERCENT_DMG_INCREASE = 1;
    protected int percentDmgIncrease;

    public Accessory(String name, String description, int ilvl, int percentDmgIncrease) {
        super(name, description, ilvl);
        if (hasValidRating(percentDmgIncrease, getMaxPercentDmgIncrease(), MIN_PERCENT_DMG_INCREASE)){
            throw new IllegalPercentDmgIncreaseException();
        }
        this.percentDmgIncrease = percentDmgIncrease;
    }

    public int getPercentDmgIncrease(){
        return percentDmgIncrease;
    }


    protected abstract int getMaxPercentDmgIncrease();
}
