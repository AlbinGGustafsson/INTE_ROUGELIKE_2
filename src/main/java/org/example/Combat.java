package org.example;

import java.util.Random;

public interface Combat {
    Random r = new Random();
    int getBaseDmg();
    double getBlockChance();
    default void dealDmg(Combat combatTarget, int damage){
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

    void takeDmg(int damage);
}
