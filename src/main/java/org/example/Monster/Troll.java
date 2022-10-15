package org.example.Monster;

import org.example.Combat;

public class Troll extends Monster{

    private static final int LEVEL_ONE_HEALTH = 400;
    private static final int COEFFICIENT_FOR_HEALTH_SCALING = 2;
    private static final int LEVEL_ONE_ATTACK_DAMAGE = 20;
    private static final int COEFFICIENT_FOR_ATTACK_DAMAGE_SCALING = 3;


    public Troll(int level) {
        super(level);

    }

    @Override
    public double calculateHealth() {
        return getLevel()*COEFFICIENT_FOR_HEALTH_SCALING + LEVEL_ONE_HEALTH;

    }

    @Override
    public void die() {

    }

    @Override
    public double attackDamage() {
        return  getLevel()*COEFFICIENT_FOR_ATTACK_DAMAGE_SCALING + LEVEL_ONE_ATTACK_DAMAGE;
    }

    @Override
    public void attack() {

    }

    @Override
    public void dealDmg(Combat combatTarget, double damage) {
        super.dealDmg(combatTarget, damage);
    }

    @Override
    public void takeDmg(double damage) {

    }
}
