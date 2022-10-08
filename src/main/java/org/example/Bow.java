package org.example;

public class Bow extends PrimaryWeapon implements AttackDmgScaling{
    public Bow(String name, String description, int ilvl, int rating) {
        super(name, description, ilvl, rating);
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
