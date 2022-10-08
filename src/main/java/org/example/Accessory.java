package org.example;

public abstract class Accessory extends Gear implements PercentDmgScaling{
    protected int percentDmgIncrease;

    public Accessory(String name, String description, int ilvl, int percentDmgIncrease) {
        super(name, description, ilvl);
        if (!hasValidPercentDmgIncrease(percentDmgIncrease)){
            throw new IllegalPercentDmgIncreaseException();
        }
        this.percentDmgIncrease = percentDmgIncrease;
    }

    public int getPercentDmgIncrease(){
        return percentDmgIncrease;
    }

    private boolean hasValidPercentDmgIncrease(int dmg){
        return dmg <= getMaxPercentDmgIncrease() && dmg >= 0;
    }

    protected abstract int getMaxPercentDmgIncrease();
}
