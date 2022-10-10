package org.example.world;

public interface Combat {
    int getBaseDmg();
    int getArmorRating();
    int getHealthPoints();
    double getBlockChance();
    default void dealDmg(Combat combatTarget, int damage){
        combatTarget.takeDmg(damage);
    }
    void takeDmg(int damage);
}
