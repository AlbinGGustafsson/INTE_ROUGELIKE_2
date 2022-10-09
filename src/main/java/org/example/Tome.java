package org.example;

public class Tome extends SubWeapon implements SpellDmgScaling{


    public Tome(String name, String description, int ilvl, int rating) {
        super(name, description, ilvl, rating);
    }

    @Override
    protected boolean instanceOfMatchingWeapons(Equipable equipable) {
        return equipable instanceof Wand;
    }

    @Override
    protected void throwException() {
        throw new IllegalSpellDmgException();
    }

    @Override
    public int getSpellDmg() {
        return rating;
    }


}
