package org.example;

import org.example.world.MovableCharacter;

public class Player extends MovableCharacter implements Combat{

    private static final int MAX_LEVEL = 100;
    private static final int BASE_PHYS_DMG = 10;
    private static final int BASE_MAGIC_DMG = 0;
    private int level;
    private int hp;
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

    public int getHp() {
        return hp;
    }

    private double getDmgMultiplier(){
        return 1 + level/10.0;
    }

    private int getPhysDmg(){
        return BASE_PHYS_DMG + equipment.getPhysDmg();
    }

    private  int getMagicDmg(){
        return BASE_MAGIC_DMG + equipment.getMagicDmg();
    }

    @Override
    public double getBlockChance() {
        return equipment.getBlockChance();
    }

    @Override
    public void takeDmg(int damage) {
        double armorfactor = 0.12 * equipment.getArmorRating() / 100;
        hp -= Math.ceil(damage * (1.0 - armorfactor));
    }

    @Override
    public BaseDamage getBaseDmg() {
        return new BaseDamage(getPhysDmg(), getMagicDmg(), getDmgMultiplier(), getDmgMultiplier());
    }
}
