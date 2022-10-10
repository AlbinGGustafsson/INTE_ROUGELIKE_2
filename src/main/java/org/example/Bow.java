package org.example;

public class Bow extends PrimaryWeapon implements PhysDmgScaling {
    public Bow(String name, String description, int ilvl, int rating) {
        super(name, description, ilvl, rating);
    }

    @Override
    protected boolean instanceOfMatchingWeapons(Equipable equipable) {
        return equipable instanceof Quiver;
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
