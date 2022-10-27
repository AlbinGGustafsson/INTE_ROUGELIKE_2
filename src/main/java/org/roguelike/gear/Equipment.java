package org.roguelike.gear;

import org.roguelike.combat.MagicDmgScaling;
import org.roguelike.combat.PercentDmgScaling;
import org.roguelike.combat.PhysDmgScaling;
import org.roguelike.inventory.Inventory;
import org.roguelike.inventory.Item;
import org.roguelike.inventory.ItemNotInInventoryException;

import java.util.*;

public class Equipment extends TreeSet<Equipable> {


    private Inventory inventory;

    public Equipment(Inventory inventory) {

        this.inventory = Objects.requireNonNull(inventory);
    }

    public int getArmorRating() {
        return this.stream().filter(equipable -> equipable instanceof ArmorRatingScaling).mapToInt(equipable -> ((ArmorRatingScaling) equipable).getArmorRating()).sum();
    }
    public int getPhysDmg(){
        return (int) Math.ceil((1 + getPercentDmgScaling()) * getBaseAttackDmg());
    }
    public int getMagicDmg(){
        return (int) Math.ceil((1 + getPercentDmgScaling()) * getBaseSpellDmg());
    }
    public double getBlockChance(){
        if (getCountOf(Shield.class) == 1){
            Shield shield = (Shield) getEquipable(Shield.class);
            assert shield != null;
            return shield.getArmorRating()/1000.0;
        }
        return 0;
    }

    private int getBaseAttackDmg() {
        return this.stream().filter(equipable -> equipable instanceof PhysDmgScaling).mapToInt(equipable -> ((PhysDmgScaling) equipable).getPhysDmg()).sum();
    }
    private int getBaseSpellDmg() {
        return this.stream().filter(equipable -> equipable instanceof MagicDmgScaling).mapToInt(equipable -> ((MagicDmgScaling) equipable).getMagicDmg()).sum();
    }
    private double getPercentDmgScaling(){
        return this.stream().filter(equipable -> equipable instanceof PercentDmgScaling).mapToInt(equipable -> ((PercentDmgScaling) equipable).getPercentDmgIncrease()).sum()/100.0;

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
