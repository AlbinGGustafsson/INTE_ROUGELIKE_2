package org.example;

public class Sword extends PrimaryWeapon implements AttackDmgScaling{



    public Sword(String name, String description, int ilvl, int attackDmg) {
        super(name, description, ilvl, attackDmg);


    }



    @Override
    public int getAttackDmg() {
        return rating;
    }

    @Override
    protected void throwException() {
        throw new IllegalAttackDmgException();
    }
}
