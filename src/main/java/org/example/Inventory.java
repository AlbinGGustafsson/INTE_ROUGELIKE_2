package org.example;

import java.util.ArrayList;
import java.util.Objects;


public class Inventory extends ArrayList<Item> {
    private static final int UPGRADE_INCREMENT = 8;
    private static final int MIN_CAPACITY = UPGRADE_INCREMENT;
    private static final int MAX_CAPACITY = 5 * UPGRADE_INCREMENT;

    private int capacity;

    private int balance;

    public Inventory(){
        this(MIN_CAPACITY);
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
        if (size > MAX_CAPACITY || size < MIN_CAPACITY || size % UPGRADE_INCREMENT != 0){
            throw new IllegalInventorySizeException("Cannot increase inventory size anymore");
        }
        capacity = size;

    }

    private boolean hasTooLargeInventory() {
        return size() > capacity;
    }

    @Override
    public boolean add(Item item) {
        super.add(Objects.requireNonNull(item));
        if (hasTooLargeInventory()) {
            throw new IllegalInventorySizeException("Inventory is at max capacity");
        }
        return true;
    }

    public void decreaseBalance(int sum){

        if(balance - sum < 0){

            throw new IllegalStateException("Balance is too low");
        }

        balance -= sum;

    }

    public void increaseBalance(int sum){

        balance += sum;
    }

    public int getBalance() {
        return balance;
    }
}
