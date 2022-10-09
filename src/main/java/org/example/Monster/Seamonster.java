package org.example.Monster;

public class Seamonster extends Monster {

    private static final int LEVEL_ONE_HEALTH = 350;
    private static final int COEFFICIENT_FOR_HEALTH_SCALING = 2;
    private static final int LEVEL_ONE_ATTACK_DAMAGE = 20;
    private static final double COEFFICIENT_FOR_ATTACK_DAMAGE_SCALING = 1.45;

    public Seamonster(int level) {
        super(level);
    }

    @Override
    public int calculateHealth() {
        return getLevel()*COEFFICIENT_FOR_HEALTH_SCALING + LEVEL_ONE_HEALTH;
    }

    @Override
    public void die() {

    }

    @Override
    public double attackDamage() {
        return getLevel()*COEFFICIENT_FOR_ATTACK_DAMAGE_SCALING + LEVEL_ONE_ATTACK_DAMAGE;
    }

    @Override
    public void attack() {

    }
}
