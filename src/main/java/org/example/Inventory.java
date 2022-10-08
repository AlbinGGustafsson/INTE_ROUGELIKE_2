package org.example;

import java.util.Arrays;

public class Inventory {
    private static final int UPGRADE_INCRAMENT = 8;
    private static final int MIN_INVENTORY = UPGRADE_INCRAMENT;
    private static final int MAX_INVENTORY = 5 * UPGRADE_INCRAMENT;


    private Item[] inventoryArray = new Item[]{};

    public Inventory(){
        this(MIN_INVENTORY);
    }

    public Inventory(int size){
        setSize(size);
    }

    public int getSize(){
        return inventoryArray.length;
    }

    public Item[] getInventoryArray(){
        return inventoryArray;
    }

    public void upgradeInventory(){
        setSize(getSize() + UPGRADE_INCRAMENT);
    }

    private void setSize(int size){
        if (size > MAX_INVENTORY || size < MIN_INVENTORY || size % UPGRADE_INCRAMENT != 0){
            throw new IllegalInventorySizeException();
        }

        inventoryArray = Arrays.copyOf(inventoryArray, size);

    }



}
