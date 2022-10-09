package org.example.Monster;

public class Vampyre extends Monster {

    public Vampyre(int level) {
        super(level);
    }

    @Override
    public int calculateHealth() {
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
