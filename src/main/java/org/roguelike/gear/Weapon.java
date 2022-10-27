package org.roguelike.gear;

public abstract class Weapon extends Gear{

    public Weapon(String name, String description, int ilvl, int rating) {
        super(name, description, ilvl, rating);
    }
    protected abstract boolean instanceOfOppositeWeapon(Equipable equipable);
    protected abstract boolean instanceOfMatchingWeapons(Equipable equipable);


    @Override
    public boolean isCompatibleWith(Equipable equipable) {
        if (instanceOfOppositeWeapon(equipable)){
            return instanceOfMatchingWeapons(equipable);
        }

        return true;
    }
}
