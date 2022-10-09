package org.example;


public class Player extends GameCharacter {
    private static final int MAX_LEVEL = 100;
    private int level;
    private Equipment equipment;
    private Inventory inventory;

    public Player(String name, Race race) {
        this(name, race, 1);
    }

    public Player(String name, Race race, int level){
        super(name, race);
        this.level = level;
        inventory = new Inventory();
    }

    public int getLevel(){
        return level;
    }

    public void equip(Equipable equipable) {
        if (!equipable.canBeEquippedBy(this)){
            throw new CannotEquipException("Too high item level");
        }
        equipment.add(equipable);
    }

}
