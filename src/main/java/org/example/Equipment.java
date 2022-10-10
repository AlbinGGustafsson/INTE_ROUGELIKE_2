package org.example;

import java.util.*;

public class Equipment extends TreeSet<Equipable> {


    private Inventory inventory;

    public Equipment(Inventory inventory) {

        this.inventory = Objects.requireNonNull(inventory);
    }

    public int getArmorRating() {

        return this.stream().filter(equipable -> equipable instanceof ArmorRatingScaling).mapToInt(equipable -> ((ArmorRatingScaling) equipable).getArmorRating()).sum();

    }

    private int getCountOf(Class<? extends Equipable> geartype){
        int count = 0;
        for (Equipable e: this) {
            if (e.getClass() == geartype){
                count++;
            }
        }

        return count;

    }

    private Equipable getEquipable(Class<? extends Equipable> geartype){
        for (Equipable e:
             this) {
            if (e.getClass() == geartype){
                return e;
            }
        }
        return null;
    }




    @Override
    public boolean add(Equipable equipable) {
        if (!inventory.contains(equipable)) {
            throw new ItemNotInInventoryException();
        }
        Class<? extends Equipable> geartype = equipable.getClass();
        if (getCountOf(geartype) == equipable.maxNumberOfSameTypeEquips()){
            this.remove(getEquipable(geartype));
        }
        inventory.remove(equipable);
        return super.add(equipable);
    }

    @Override
    public boolean remove(Object o) {
        if (!this.contains(o)){
            return false;
        }
        inventory.add((Item) o);
        return super.remove(o);
    }
}
