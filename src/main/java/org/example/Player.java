package org.example;


public class Player extends GameCharacter {
    private static final int MAX_LEVEL = 100;
    private int level;
    private Helmet helmet;
    private Chestpiece chest;
    private Gloves gloves;
    private Boots boots;
    private Ring ring1;
    private Ring ring2;
    private Necklace necklace;
    private Belt belt;
    private PrimaryWeapon mainhand;
    private SubWeapon offhand;
    private Inventory inventory;

    public Player(String name, Race race) {
        this(name, race, 1);
    }

    public Player(String name, Race race, int level){
        super(name, race);
        this.level = level;
    }

    public int getLevel(){
        return level;
    }
}
