package org.example.Monster;


import org.example.characters.Player;
import org.example.world.PrintFormatConstants;
import org.example.world.Water;

public class Goomba extends Monster {

    private static final double GOOMBA_DAMAGE_ADD_ON = 50;
    private static final int BASE_DAMAGE = 20;
    private boolean isDamageAddOnInAffect;


    public Goomba(int level) {
        super(level);
        addTerrain(Water.class);
    }

    @Override
    public double calculateHealth() {
        return getLevel()* 2.5 + 50;
    }



    @Override
    public double attackDamage() {
        if(isDamageAddOnInAffect){
            isDamageAddOnInAffect = false;
            return BASE_DAMAGE * getLevel() + GOOMBA_DAMAGE_ADD_ON;
        }

        return BASE_DAMAGE*getLevel();
    }

    @Override
    public void monsterSpecificAttack(Player p) {
        printBattleMessage();
        pauseExecution();
        checkIfLevelDifference(p);
    }

    private void checkIfLevelDifference(Player p) {
        if(p.getLevel() < getLevel()){
            isDamageAddOnInAffect = true;
        }
    }

    private void printBattleMessage(){
        getPrintStream().println("Whom is the fool that dare engage in combat with a Goomba?");
    }



    public String toString(){
        return PrintFormatConstants.BOLD + PrintFormatConstants.RED + "G" + PrintFormatConstants.RESET;
    }

}