package org.example.Monster;

public class Goomba extends Monster {
    public Goomba(int level) {
        super(level);
    }

    @Override
    public double calculateHealth() {
        return 0;
    }

    @Override
    public void die() {

    }

    @Override
    public double attackDamage() {
        return 0;
    }

    @Override
    public void attack() {

    }
}
