package org.example;

import java.util.ArrayList;


public class Inventory extends ArrayList<Item> {
    private static final int UPGRADE_INCREMENT = 8;
    private static final int MIN_INVENTORY = UPGRADE_INCREMENT;
    private static final int MAX_INVENTORY = 5 * UPGRADE_INCREMENT;

    private int capacity;

    public Inventory(){
        this(MIN_INVENTORY);
    }

    public Inventory(int size){
        setCapacity(size);
    }

    public int getCapacity(){
        return capacity;
    }

    public void upgradeInventory(){
        setCapacity(capacity + UPGRADE_INCREMENT);
    }


    private void setCapacity(int size){
        if (size > MAX_INVENTORY || size < MIN_INVENTORY || size % UPGRADE_INCREMENT != 0){
            throw new IllegalInventorySizeException("Cannot increase inventory size anymore");
        }
        capacity = size;

    }

    private boolean hasTooLargeInventory() {
        return size() > capacity;
    }

    @Override
    public boolean add(Item item) {
        super.add(item);
        if (hasTooLargeInventory()) {
            throw new IllegalInventorySizeException("Inventory is at max capacity");
        }
        return true;
    }
}
