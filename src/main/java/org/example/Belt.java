package org.example;

public class Belt extends Accessory{
    public Belt(String name, String description, int ilvl, int percentDmgIncrease) {
        super(name, description, ilvl, percentDmgIncrease);
    }

    @Override
    protected int getMaxPercentDmgIncrease() {
        return 0;
    }
}
