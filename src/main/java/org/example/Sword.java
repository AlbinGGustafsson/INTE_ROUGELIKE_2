package org.example;

public class Sword extends PrimaryWeapon implements PhysDmgScaling {



    public Sword(String name, String description, int ilvl, int attackDmg) {
        super(name, description, ilvl, attackDmg);


    }

    @Override
    protected boolean instanceOfMatchingWeapons(Equipable equipable) {
        return equipable instanceof Dagger || equipable instanceof Shield;
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
