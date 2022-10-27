package org.roguelike.gear;

public abstract class Armor extends Gear implements ArmorRatingScaling {
    private static final int MIN_ARMOR_RATING = 0;




    public Armor(String name, String description, int ilvl, int armorRating) {
        super(name, description, ilvl, armorRating);


    }

    @Override
    public int getArmorRating() {
        return rating;
    }

    @Override
    protected int getMinRating(){
        return MIN_ARMOR_RATING;
    }

    @Override
    protected void throwException(){
        throw new IllegalArmorRatingException();
    }

    @Override
    public boolean isCompatibleWith(Equipable equipable) {
        return true;
    }


}
