package org.example;

public abstract class Gear extends Item {
    private static final int MAX_ITEM_LEVEL = 100;
    private static final double MAX_QUALITY = 1.0;
    private static final double MIN_QUALITY = 0.1;
    protected int itemlevel;
    protected double quality = 1.0;

    public Gear(String name, String description, int ilvl) {
        super(name, description);
        setItemlevel(ilvl);
    }

    private void setItemlevel(int ilvl){
        if (MAX_ITEM_LEVEL < ilvl || ilvl < 1){
            throw new IllegalItemLevelException();
        }
        itemlevel = ilvl;
    }
}
