package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {
    private static final Inventory INVENTORY = new Inventory();
    private static final Equipment EQUIPMENT = new Equipment(INVENTORY);

    @Test
    public void creatingEquipmentWithNullInventoryDoesntWork() {
        assertThrows(NullPointerException.class, ()-> new Equipment(null));
    }

    @Test
    public void addingHelmetWorks() {
        Helmet h = new Helmet("", "", 12, 123);
        INVENTORY.add(h);
        EQUIPMENT.add(h);
        assertTrue(EQUIPMENT.contains(h));
    }

    @Test
    public void addingSecondHelmetOnlyContainsLastHelmet() {
        Helmet h1 = new Helmet("", "", 12, 123);
        Helmet h2 = new Helmet("", "", 12, 122);
        INVENTORY.add(h1);
        INVENTORY.add(h2);
        EQUIPMENT.add(h1);
        EQUIPMENT.add(h2);
        assertTrue(EQUIPMENT.contains(h2) && !EQUIPMENT.contains(h1));
    }

    @Test
    public void addingRemovesEquipableFromInventory(){
        Helmet h = new Helmet("", "", 12, 123);
        INVENTORY.add(h);
        EQUIPMENT.add(h);
        assertFalse(INVENTORY.contains(h));
    }

    @Test
    public void addingEquipableNotInInventoryThrowsException(){
        Helmet h = new Helmet("", "", 12, 123);
        assertThrows(ItemNotInInventoryException.class, ()->EQUIPMENT.add(h));
    }

    @Test
    public void removingWorks(){
        Helmet h = new Helmet("", "", 12, 123);
        INVENTORY.add(h);
        EQUIPMENT.add(h);
        EQUIPMENT.remove(h);
        assertFalse(EQUIPMENT.contains(h));
    }

    @Test
    public void removingAddsEquipableInInventory(){
        Helmet h = new Helmet("", "", 12, 123);
        INVENTORY.add(h);
        EQUIPMENT.add(h);
        EQUIPMENT.remove(h);
        assertTrue(INVENTORY.contains(h));
    }

}