package org.example;

import java.util.Random;

public interface Combat {
    Random r = new Random();
    BaseDamage getBaseDmg();
    double getBlockChance();
    default void dealDmg(Combat combatTarget, double damage){
        if (blocked()) {
            //target blocked the dmg
        }
        else {
            combatTarget.takeDmg(damage);

        }
    }

    default boolean blocked(){
        return r.nextDouble() < getBlockChance();
    }

    void takeDmg(double damage);

}
