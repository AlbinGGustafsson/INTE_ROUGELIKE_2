package org.example;


public class Player extends GameCharacter {
    private static final int MAX_LEVEL = 100;
    int level = 1;
    Helmet helmet;
    Chestpiece chest;
    Gloves gloves;
    Boots boots;
    Ring ring1;
    Ring ring2;
    Necklace necklace;
    Belt belt;
    PrimaryWeapon mainhand;
    SubWeapon offhand;

    public Player(String name, Race race) {
        super(name, race);
    }
}
