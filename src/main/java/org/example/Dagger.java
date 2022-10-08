package org.example;

public class Dagger extends SubWeapon implements AttackDmgScaling{
    public Dagger(String name, String description, int ilvl, int rating) {
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
