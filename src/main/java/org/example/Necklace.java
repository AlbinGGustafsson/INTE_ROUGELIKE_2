package org.example;

public class Necklace extends Accessory{

    public Necklace(String name, String description, int ilvl, int percentDmgIncrease) {
        super(name, description, ilvl, percentDmgIncrease);
    }

    @Override
    protected int getMaxPercentDmgIncrease() {
        return 0;
    }
}
