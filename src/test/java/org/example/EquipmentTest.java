package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {
   Inventory inventory;
   Equipment equipment;

    @BeforeEach
    public void setup(){
        inventory = new Inventory();
        equipment = new Equipment(inventory);
    }

    @Test
    public void creatingEquipmentWithNullInventoryDoesntWork() {
        assertThrows(NullPointerException.class, ()-> new Equipment(null));
    }

    @Test
    public void addingHelmetWorks() {
        Helmet h = new Helmet("", "", 12, 123);
        inventory.add(h);
        equipment.add(h);
        assertTrue(equipment.contains(h));
    }

    @Test
    public void addingSecondHelmetOnlyContainsLastHelmet() {
        Helmet h1 = new Helmet("", "", 12, 123);
        Helmet h2 = new Helmet("", "", 12, 122);
        inventory.add(h1);
        inventory.add(h2);
        equipment.add(h1);
        equipment.add(h2);
        assertTrue(equipment.contains(h2) && !equipment.contains(h1));
    }

    @Test
    public void addingRemovesEquipableFromInventory(){
        Helmet h = new Helmet("", "", 12, 123);
        inventory.add(h);
        equipment.add(h);
        assertFalse(inventory.contains(h));
    }

    @Test
    public void addingEquipableNotInInventoryThrowsException(){
        Helmet h = new Helmet("", "", 12, 123);
        assertThrows(ItemNotInInventoryException.class, ()-> equipment.add(h));
    }

    @Test
    public void removingWorks(){
        Helmet h = new Helmet("", "", 12, 123);
        inventory.add(h);
        equipment.add(h);
        equipment.remove(h);
        assertFalse(equipment.contains(h));
    }

    @Test
    public void removingAddsEquipableInInventory(){
        Helmet h = new Helmet("", "", 12, 123);
        inventory.add(h);
        equipment.add(h);
        equipment.remove(h);
        assertTrue(inventory.contains(h));
    }

    @Test
    public void removingNonEquippedEquipableDoesntWork(){
        Helmet h = new Helmet("", "", 12, 123);
        inventory.add(h);
        assertFalse(equipment.remove(h));
    }

    @Test
    public void removingNonEquippedEquipableDoesntAdditInInventory(){
        Helmet h = new Helmet("", "", 12, 123);
        equipment.remove(h);
        assertFalse(inventory.contains(h));
    }

}