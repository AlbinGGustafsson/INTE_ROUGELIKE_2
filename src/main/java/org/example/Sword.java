package org.example;

public class Sword extends PrimaryWeapon implements AttackDmgScaling{
    private static final int MAX_ATTACK_DMG = 1000;
    private static final int MIN_ATTACK_DMG = 1;
    protected int attackDmg;

    public Sword(String name, String description, int ilvl, int attackDmg) {
        super(name, description, ilvl);
        if (hasValidRating(attackDmg, MAX_ATTACK_DMG, MIN_ATTACK_DMG)){
            throw new IllegalAttackDmgException();
        }
        this.attackDmg = attackDmg;
    }



    @Override
    public int getAttackDmg() {
        return attackDmg;
    }
}
