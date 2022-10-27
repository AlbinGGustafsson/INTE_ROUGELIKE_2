package org.roguelike.gear;

import org.roguelike.combat.MagicDmgScaling;

public class Wand extends PrimaryWeapon implements MagicDmgScaling {


    public Wand(String name, String description, int ilvl, int spellDmg) {
        super(name, description, ilvl, spellDmg);

    }

    @Override
    protected boolean instanceOfMatchingWeapons(Equipable equipable) {
        return equipable instanceof Tome || equipable instanceof Shield;
    }

    @Override
    public int getMagicDmg() {
        return rating;
    }


    @Override
    protected void throwException() {
        throw new IllegalSpellDmgException();
    }


}
