package org.example;

public abstract class Accessory extends Gear implements PercentDmgScaling{
    private static final int MIN_PERCENT_DMG_INCREASE = 1;


    public Accessory(String name, String description, int ilvl, int percentDmgIncrease) {
        super(name, description, ilvl, percentDmgIncrease);

    }

    @Override
    public int getPercentDmgIncrease() {
        return rating;
    }

    @Override
    protected int getMinRating(){
        return MIN_PERCENT_DMG_INCREASE;
    }

    @Override
    protected void throwException(){
        throw new IllegalPercentDmgIncreaseException();
    }

    @Override
    public boolean isCompatibleWith(Equipable equipable) {
        return true;
    }
}
