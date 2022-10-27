package org.roguelike.gear;

import org.roguelike.combat.PhysDmgScaling;

public class Dagger extends SubWeapon implements PhysDmgScaling {
    public Dagger(String name, String description, int ilvl, int rating) {
        super(name, description, ilvl, rating);
    }

    @Override
    protected boolean instanceOfMatchingWeapons(Equipable equipable) {
        return equipable instanceof Sword;
    }

    @Override
    public int getPhysDmg() {
        return rating;
    }

    @Override
    protected void throwException() {
        throw new IllegalAttackDmgException();
    }


}
