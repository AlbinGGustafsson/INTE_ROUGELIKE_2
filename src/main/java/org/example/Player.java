package org.example;


public class Player extends GameCharacter {
    int level;
    Helmet helmet;
    Chestpiece chest;
    Gloves gloves;
    Boots boots;
    Ring ring1;
    Ring ring2;
    Necklace necklace;
    Belt belt;

    public Player(String name, Race race) {
        super(name, race);
    }
}
