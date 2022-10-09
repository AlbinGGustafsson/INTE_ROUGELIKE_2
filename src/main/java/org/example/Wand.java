package org.example;

public class Wand extends PrimaryWeapon implements SpellDmgScaling{


    public Wand(String name, String description, int ilvl, int spellDmg) {
        super(name, description, ilvl, spellDmg);

    }

    @Override
    protected boolean instanceOfMatchingWeapons(Equipable equipable) {
        return equipable instanceof Tome || equipable instanceof Shield;
    }

    @Override
    public int getSpellDmg() {
        return rating;
    }


    @Override
    protected void throwException() {
        throw new IllegalSpellDmgException();
    }


}
