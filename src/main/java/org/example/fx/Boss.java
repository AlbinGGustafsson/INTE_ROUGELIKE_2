package org.example.fx;

import org.example.Monster.Monster;
import org.example.Player;
import org.example.world.Terrain;

public class Boss extends Monster {

    public Boss(int level) {
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

    // @Override


    @Override
    public void takeDmg(double damage) {
        super.takeDmg(damage);
    }

}
