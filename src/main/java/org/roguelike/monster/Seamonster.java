package org.roguelike.monster;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.roguelike.characters.Player;
import org.roguelike.world.PrintFormatConstants;
import org.roguelike.world.Water;

public class Seamonster extends Monster {

    private static final int LEVEL_ONE_HEALTH = 60;
    private static final int COEFFICIENT_FOR_HEALTH_SCALING = 2;
    private static final int LEVEL_ONE_ATTACK_DAMAGE = 20;
    private static final double COEFFICIENT_FOR_ATTACK_DAMAGE_SCALING = 1.45;

    public Seamonster(int level) {
        super(level);
        addTerrain(Water.class);
    }

    @Override
    public double calculateHealth() {
        return getLevel()*COEFFICIENT_FOR_HEALTH_SCALING + LEVEL_ONE_HEALTH;
    }



    @Override
    public double attackDamage() {
        return getLevel()*COEFFICIENT_FOR_ATTACK_DAMAGE_SCALING + LEVEL_ONE_ATTACK_DAMAGE;
    }

    @Override
    public void monsterSpecificAttack(Player p) {
        changeTileTerrainIfPlayerHasLowerLevel(p);
        makePlayerAbleToSwim(p);
    }

    private void changeTileTerrainIfPlayerHasLowerLevel(Player p) {
        if(isMonsterLevelHigher(p)){
            getRoom().getTile(getPosition()).setTerrain(new Water());
        }
    }

    private boolean isMonsterLevelHigher(Player p) {
        return getLevel() >= p.getLevel();
    }

    private void makePlayerAbleToSwim(Player p) {
        if(isMonsterLevelHigher(p)){
            p.addTerrain(Water.class);
        }
    }

    @Override
    public Text getText() {
        Text text = new Text("S");
        text.setFill(Color.RED);
        return text;
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.RED + "S" + PrintFormatConstants.RESET;
    }
}