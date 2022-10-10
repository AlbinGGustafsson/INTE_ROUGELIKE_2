package org.example;

import org.example.world.MovableCharacter;

public class Player extends MovableCharacter implements Combat{

    private static final int MAX_LEVEL = 100;
    private int level;
    private int healthPoints;
    private Equipment equipment;
    private Inventory inventory;

    public Player(String name, Race race) {
        this(name, race, 1);
    }

    public Player(String name, Race race, int level){
        super(name, race);
        this.level = level;
        inventory = new Inventory();
        equipment = new Equipment(inventory);
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

    public void unequip(Equipable equipable) {
        equipment.remove(equipable);
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public Inventory getInventory() {
        return (Inventory) inventory.clone();
    }

    public Equipment getEquipment() {
        return (Equipment) equipment.clone();
    }

    @Override
    public int getBaseDmg() {
        return 0;
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public double getBlockChance() {
        return 0;
    }

    @Override
    public void takeDmg(int damage) {
        double armorfactor = 0.12 * (getArmor()) / 100;
        healthPoints -= damage * (1 - armorfactor);
    }

    private int getArmor() {
        int armorrating = 0;
        for (ArmorRatingScaling ars: (ArmorRatingScaling[]) equipment.stream().filter(equipable -> equipable instanceof ArmorRatingScaling).toArray()) {
            armorrating += ars.getArmorRating();
        }
        return armorrating;
    }
}
