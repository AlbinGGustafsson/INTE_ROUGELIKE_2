package org.example.Monster;

import org.example.characters.Player;
import org.example.world.Terrain;

public class Vampyre extends Monster {

    public Vampyre(int level) {
        super(level);
    }

    @Override
    public double calculateHealth() {
        return 0;
    }



    @Override
    public double attackDamage() {
        return 0;
    }

    @Override
    public void monsterSpecificAttack(Player p) {

    }


    @Override
    public String toString() {
        return null;
    }
}
