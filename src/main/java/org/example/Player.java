package org.example;

import org.example.world.*;

public class Player extends MovableCharacter implements Combat{
    private static final int MAX_LEVEL = 100;
    //leveling equation for player = (x-1)^4.5
    private static final int BASE_PHYS_DMG = 10;
    private static final int BASE_MAGIC_DMG = 0;
    private int level;
    private int exp;
    private int hp;

    private final Equipment equipment;
    private final Inventory inventory;

    public Player(String name, Race race) {
        this(name, race, 1);
    }

    public Player(String name, Race race, int level){
        super(name, race);
        gainExpUntilRightLevelIsReached(level);
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

    public void gainExp(int exp) {
        if (this.exp + exp <= maxExp()){
            this.exp+=exp;
        }
        else {
            this.exp = maxExp();
        }
        levelUp();
    }

    public void gainExp(){
        gainExp(1);
    }

    public int getExp() {
        return exp;
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

    private void levelUp(){
        if (getExpRequiredForLevel(level+1) <= exp){
            level++;
            levelUp();
        }
    }

    private void gainExpUntilRightLevelIsReached(int level){
        gainExp(getExpRequiredForLevel(level));
    }

    private int getExpRequiredForLevel(int level){
        return (int) Math.ceil(Math.pow((level-1), 4.5));
    }

    private int maxExp(){
        return getExpRequiredForLevel(MAX_LEVEL);
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

    @Override
    protected boolean interactWithTile(Position position){
        Tile tile = getRoom().getTile(position);

        if (tile.getTerrain() instanceof Water water && !getTerrains().contains(Water.class)){
            water.printNonReachableMessage();
            return true;
        }

        if (tile.getTerrain() instanceof Floor floor && !getTerrains().contains(Floor.class)){
            floor.printNonReachableMessage();
            return true;
        }

        if (tile.getNonStackableEntity() instanceof Door door){
            setRoom(changeRoom(door));
            return true;
        }

        if (tile.getNonStackableEntity() instanceof Wall wall){
            wall.printNonReachableMessage();
            return true;
        }
        if (tile.getNonStackableEntity() instanceof Stone stone){
            stone.printNonReachableMessage();
            return true;
        }

        return false;
    }

    private Room changeRoom(Door d){

        getRoom().removeNonStackableEntity(getPosition());
        Room newRoom = null;

        if (d instanceof LeftDoor l){
            newRoom = getRoom().getPreviousRoom();
            setPos(newRoom.getRightDoorPos().getPos(Direction.LEFT));
            l.printWalkthru();
        }
        if (d instanceof RightDoor r){
            newRoom = getRoom().getNextRoom();
            setPos(newRoom.getLeftDoorPos().getPos(Direction.RIGHT));
            r.printWalkthru();
        }

        assert newRoom != null;
        newRoom.setNonStackableEntity(this, getPosition());
        return newRoom;

    }


    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.PURPLE + "P" + PrintFormatConstants.RESET;
    }



}
