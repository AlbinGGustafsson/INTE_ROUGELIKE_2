package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    @Test
    public void creatingInventoryGivesNoError(){
        Inventory i = new Inventory();
        assertEquals(8, i.getSize());
    }

    @Test
    public void upgradingInventoryCreatesRightSize(){
        Inventory i = new Inventory();
        i.upgradeInventory();
        assertEquals(16, i.getSize());
    }

    @Test
    public void throwsExceptionIfTooBigInventory(){
        Inventory i = new Inventory();
        i.upgradeInventory();
        i.upgradeInventory();
        i.upgradeInventory();
        i.upgradeInventory();
        assertThrows(IllegalInventorySizeException.class, i::upgradeInventory);
    }

    @Test
    public void throwsExceptionIfSizeIsLowerOrNotDivisibleByEight(){
        assertThrows(IllegalInventorySizeException.class, () -> {
            new Inventory(0);
            new Inventory(15);
        });
    }

    @Test
    public void arraySizeIsSameAsSize(){
        Inventory i = new Inventory();
        assertEquals(i.getSize(), i.getInventoryArray().length);
    }



}