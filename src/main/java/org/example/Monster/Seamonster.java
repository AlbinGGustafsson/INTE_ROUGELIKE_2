package org.example.Monster;

import org.example.Player;
import org.example.world.Floor;
import org.example.world.Water;

public class Seamonster extends Monster {

    private static final int LEVEL_ONE_HEALTH = 350;
    private static final int COEFFICIENT_FOR_HEALTH_SCALING = 2;
    private static final int LEVEL_ONE_ATTACK_DAMAGE = 20;
    private static final double COEFFICIENT_FOR_ATTACK_DAMAGE_SCALING = 1.45;

    public Seamonster(int level) {
        super(level);
        removeTerrain(Floor.class);
        addTerrain(Water.class);
    }

    @Override
    public double calculateHealth() {
        return getLevel()*COEFFICIENT_FOR_HEALTH_SCALING + LEVEL_ONE_HEALTH;
    }



    @Override
    public double attackDamage() {
        return getLevel()*COEFFICIENT_FOR_ATTACK_DAMAGE_SCALING + LEVEL_ONE_ATTACK_DAMAGE;
    }

    @Override
    public void monsterSpecificAttack(Player p) {

    }

}
