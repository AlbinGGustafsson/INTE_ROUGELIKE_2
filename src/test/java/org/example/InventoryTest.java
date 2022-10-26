package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    @Test
    public void creatingInventoryGivesNoError(){

        assertEquals(8, new Inventory().getCapacity());
    }

    @Test
    public void upgradingInventoryCreatesRightSize(){
        Inventory i = new Inventory();
        i.upgradeInventory();
        assertEquals(16, i.getCapacity());
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

    /*@Test
    public void arraySizeIsSameAsSize(){
        Inventory i = new Inventory();
        assertEquals(i.getCapacity(), i.getInventoryArray().length);
    }*/

    @Test
    public void addingItemAddsTheItem(){
        Inventory i = new Inventory();
        Bow b = new Bow("", "", 4, 142);
        i.add(b);
        assertTrue(i.contains(b));

    }

    @Test
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public void addingItemPastCapacityThrowsException(){
        Inventory i = new Inventory();
        Bow b = new Bow("", "", 4, 142);
        i.add(b);
        i.add(b);
        i.add(b);
        i.add(b);
        i.add(b);
        i.add(b);
        i.add(b);
        i.add(b);
        assertThrows(IllegalInventorySizeException.class, () -> i.add(b));
    }

    @Test
    public void addingNullThrowsException(){

        assertThrows(NullPointerException.class, ()->new Inventory().add(null));
    }

    @Test
    public void removingItemFromInventoryWorks(){
        Inventory i = new Inventory();
        Bow b = new Bow("", "", 12, 123);
        i.add(b);
        i.remove(b);
        assertFalse(i.contains(b));
    }

}