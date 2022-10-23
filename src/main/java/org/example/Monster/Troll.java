package org.example.Monster;

import org.example.Equipable;
import org.example.Shield;
import org.example.characters.Player;
import org.example.world.PrintFormatConstants;


public class Troll extends Monster{

    private static final int LEVEL_ONE_HEALTH = 40;
    private static final int COEFFICIENT_FOR_HEALTH_SCALING = 2;
    private static final int LEVEL_ONE_ATTACK_DAMAGE = 400;
    private static final int COEFFICIENT_FOR_ATTACK_DAMAGE_SCALING = 3;


    public Troll(int level) {
        super(level);

    }

    @Override
    public double calculateHealth() {
        return getLevel()*COEFFICIENT_FOR_HEALTH_SCALING + LEVEL_ONE_HEALTH;

    }


    @Override
    public double attackDamage() {
        return  getLevel()*COEFFICIENT_FOR_ATTACK_DAMAGE_SCALING + LEVEL_ONE_ATTACK_DAMAGE;
    }

    @Override
    public void monsterSpecificAttack(Player p) {
        unEquipPlayersShields(p);
    }

    private void unEquipPlayersShields(Player p) {
        for(Equipable e :p.getEquipment()){
            if(e instanceof Shield shield){
                p.unequip(shield);
            }
        }

    }


    public String toString(){
        return PrintFormatConstants.BOLD + PrintFormatConstants.RED + "T" + PrintFormatConstants.RESET;
    }
}