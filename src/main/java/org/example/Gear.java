package org.example;

public abstract class Gear {
    private static final int MAX_ITEM_LEVEL = 100;
    protected int itemlevel;

    public Gear(int ilvl) {
        setItemlevel(ilvl);
    }

    private void setItemlevel(int ilvl){
        if (MAX_ITEM_LEVEL < ilvl || ilvl < 1){
            throw new IllegalItemLevelException();
        }
        itemlevel = ilvl;
    }
}
