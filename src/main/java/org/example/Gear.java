package org.example;

public abstract class Gear extends Item {
    private static final int MAX_ITEM_LEVEL = 100;
    protected int itemlevel;

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
