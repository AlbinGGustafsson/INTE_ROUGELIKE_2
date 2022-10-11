package org.example.Monster;

import org.example.world.Position;

public class Boss extends Monster {
    public Boss(int level) {
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
