package org.roguelike.gear;

import org.roguelike.inventory.Item;
import org.roguelike.characters.Player;

public abstract class Gear extends Item implements Equipable{
    private static final int MAX_ITEM_LEVEL = 100;
    private static final double MAX_QUALITY = 1.0;
    private static final double MIN_QUALITY = 0.1;
    private static final int MAX_NUMBER_OF_SAME_TYPE_EQUIPS = 1;

    protected int itemlevel;
    protected int rating;
    protected double quality = 1.0;

    public Gear(String name, String description, int ilvl, int rating) {
        super(name, description);
        setItemlevel(ilvl);
        setRating(rating);

        }


    protected abstract int getMaxRating();
    protected abstract int getMinRating();
    protected abstract void throwException();

    protected boolean hasInvalidRating(int rating, int max_rating, int min_rating) {
        return rating > max_rating || rating < min_rating;
    }

    private void setItemlevel(int ilvl){
        if (MAX_ITEM_LEVEL < ilvl || ilvl < 1){
            throw new IllegalItemLevelException();
        }
        itemlevel = ilvl;
    }
    private void setRating(int rating) {
        if (hasInvalidRating(rating, getMaxRating(), getMinRating())) {
            throwException();
        }
        this.rating = rating;
    }

    @Override
    public boolean canBeEquippedBy(Player player) {
        return player.getLevel() >= itemlevel;
    }

    @Override
    public int compareTo(Equipable o) {
        if (o instanceof Gear og){

            if (itemlevel == og.itemlevel){
               if (rating == og.rating){
                   if (!this.equals(og)){
                       return -1;
                   }
               }
               return rating - og.rating;
            }
            return itemlevel - og.itemlevel;
        }
        return -1;
    }

    @Override
    public int maxNumberOfSameTypeEquips() {
        return MAX_NUMBER_OF_SAME_TYPE_EQUIPS;
    }
}