package org.example;

public class Quiver extends SubWeapon implements PhysDmgScaling {
    public Quiver(String name, String description, int ilvl, int rating) {
        super(name, description, ilvl, rating);
    }

    @Override
    public int getPhysDmg() {
        return rating;
    }

    @Override
    protected void throwException() {
        throw new IllegalAttackDmgException();
    }

    @Override
    protected boolean instanceOfMatchingWeapons(Equipable equipable) {
        return equipable instanceof Bow;
    }
}
