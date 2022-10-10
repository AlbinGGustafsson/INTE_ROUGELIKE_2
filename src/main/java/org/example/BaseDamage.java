package org.example;

public class BaseDamage {
    private int physDmg;
    private int magicDmg;

    public BaseDamage() {
        this(0,0, 1, 1);
    }

    public BaseDamage(int physDmg, int magicDmg, double physDmgMultiplier, double magicDmgMultiplier) {
        this.physDmg = (int) Math.ceil(physDmg * physDmgMultiplier);
        this.magicDmg = (int) Math.ceil(magicDmg * magicDmgMultiplier);
    }

    public int getPhysDmg() {
        return physDmg;
    }

    public int getMagicDmg() {
        return magicDmg;
    }
}
