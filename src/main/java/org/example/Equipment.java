package org.example;

import java.util.ArrayList;

public class Equipment extends ArrayList<Equipable> {
    private static final int GEAR_SLOTS = 8;

    private Inventory inventory;

    public Equipment(Inventory inventory) {
        super(GEAR_SLOTS);
        this.inventory = inventory;
    }
}
