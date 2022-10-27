package org.roguelike.monster;


import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.roguelike.characters.Player;
import org.roguelike.world.PrintFormatConstants;
import org.roguelike.world.Water;

public class Goomba extends Monster {

    private static final double GOOMBA_DAMAGE_ADD_ON = 10;
    private int baseDamage = 20;
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
        return baseDamage*getLevel();
    }

    @Override
    public void monsterSpecificAttack(Player p) {
        printBattleMessage();
        pauseExecution();
        if(goombaHasHigherLevel(p)){
            baseDamage += GOOMBA_DAMAGE_ADD_ON;
        }
    }

    private boolean goombaHasHigherLevel(Player p) {
        return p.getLevel() < getLevel();

    }

    private void printBattleMessage(){
        getPrintStream().println("Whom is the fool that dare engage in combat with a Goomba?");
    }

    @Override
    public Text getText() {
        Text text = new Text("G");
        text.setFill(Color.RED);
        return text;
    }

    public String toString(){
        return PrintFormatConstants.BOLD + PrintFormatConstants.RED + "G" + PrintFormatConstants.RESET;
    }

}