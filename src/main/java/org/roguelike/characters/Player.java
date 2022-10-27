package org.roguelike.characters;

import org.roguelike.combat.BaseDamage;
import org.roguelike.combat.Combat;
import org.roguelike.gear.CannotEquipException;
import org.roguelike.gear.Equipable;
import org.roguelike.gear.Equipment;
import org.roguelike.inventory.Inventory;
import org.roguelike.inventory.Item;
import org.roguelike.quest.QuestLog;
import org.roguelike.world.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.roguelike.monster.Monster;

public class Player extends MovableCharacter implements Combat {

    private static final String APPEARANCE_CSS_STYLE = "-fx-font-family: 'monospaced';-fx-font-size: 20;-fx-font-weight: bold";

    private static final int MAX_LEVEL = 100;
    private static final int BASE_PHYS_DMG = 10;
    private static final int BASE_MAGIC_DMG = 0;



    private Text guiAppearance;
    private int level;
    private int totalExp;
    private int hp;


    private final Equipment equipment;
    private final Inventory inventory;


    private final QuestLog questLog;

    public Player(String name, Race race) {
        this(name, race, 1);
    }

    public Player(String name, Race race, int level){
        super(name, race);

        gainExpUntilRightLevelIsReached(level);
        throwExceptionIfNameHasWrongFormat();

        inventory = new Inventory();
        equipment = new Equipment(inventory);
        questLog = new QuestLog();

        setHp();
        setDefaultGuiAppearance();
    }

    private void throwExceptionIfNameHasWrongFormat() {
        if (getName().length() == 0){
           throw new IllegalArgumentException("name cant be empty");
        }

        if (getName().length() > 20){
            throw new IllegalArgumentException("name can only be 20 characters");
        }

        if(nameContainsWhiteSpace()){
            throw new IllegalArgumentException("name cant contain whitespace");
        }
    }

    private void setHp(){
        hp = level*2 + 400;
    }

    private boolean nameContainsWhiteSpace(){
            for(int i = 0; i < getName().length(); i++){
                if(Character.isWhitespace(getName().charAt(i))){
                    return true;
                }
            }
        return false;
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
        if (this.totalExp + exp <= maxExp()){
            this.totalExp +=exp;
        }
        else {
            this.totalExp = maxExp();
        }
        levelUp();
    }

    public int getTotalExp() {
        return totalExp;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Equipment getEquipment() {
        return (Equipment) equipment.clone();
    }

    public QuestLog getQuestLog() {
        return questLog;
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
        if (getExpRequiredForLevel(level+1) <= totalExp){
            level++;
            setHp();
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
    public void takeDmg(double damage) {
        double armorfactor = 0.12 * equipment.getArmorRating() / 100;
        hp -= Math.ceil(damage * (1.0 - armorfactor));
    }

    @Override
    public BaseDamage getBaseDmg() {
        return new BaseDamage(getPhysDmg(), getMagicDmg(), getDmgMultiplier(), getDmgMultiplier());
    }

    public boolean interactWithTile(Tile tile) {

        if (!tile.getItems().isEmpty()) {
            getPrintStream().print("You found ");
            tile.getItems().forEach(item -> getPrintStream().print(item + " "));
            getPrintStream().println();
            tile.removeAllItems();
        }

        if (tile.getEntity() instanceof Door door) {
            updateRoom(changeRoom(door));
            return true;
        }
        if (tile.getTerrain() instanceof Water water && !getTerrains().contains(Water.class)) {
            water.printNonReachableMessage();
        }

        if (tile.getEntity() instanceof Wall wall) {
            wall.printNonReachableMessage();
        }
        if (tile.getEntity() instanceof Stone stone) {
            stone.printNonReachableMessage();
        }

        if(tile.getEntity() instanceof Monster monster){
            monster.printNonReachableMessage();
            monster.battleWithPlayer(this);
            tile.removeEntity();
        }

        if (tile.getEntity() instanceof NPC npc) {
            npc.interact(this);
        }
        return false;
    }

    public void setGuiAppearance(Text guiAppearance) {
        this.guiAppearance = guiAppearance;
        guiAppearance.setStyle(APPEARANCE_CSS_STYLE);
    }

    private void setDefaultGuiAppearance(){
        guiAppearance = new Text("P");
        guiAppearance.setStyle(APPEARANCE_CSS_STYLE);
        guiAppearance.setFill(Color.PURPLE);
    }


    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.PURPLE + guiAppearance.getText() + PrintFormatConstants.RESET;
    }

    @Override
    public Text getText() {
        return guiAppearance;
    }
}

