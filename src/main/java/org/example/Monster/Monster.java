package org.example.Monster;

import org.example.Combat;
import org.example.characters.Player;
import org.example.Race;
import org.example.world.MovableCharacter;


public abstract class Monster extends MovableCharacter implements Combat, PauseExecutionForCombat {

  private final int level;
  private double health;

  public Monster(int level){
    super("Monster", Race.MONSTER );

    if(level < 1 || level > 100){
      throw new IllegalArgumentException();
    }
    this.level = level;
    setHealth();
  }



  @Override
  public double getBlockChance() {
    return 0;
  }

  @Override
  public void dealDmg(Combat combatTarget, double damage) {
    Combat.super.dealDmg(combatTarget, damage);
  }

  @Override
  public boolean blocked() {
    return Combat.super.blocked();
  }

  @Override
  public void takeDmg(double damage) {
    health = health - damage;
  }

  public abstract double calculateHealth();


  public abstract double attackDamage();


  private void setHealth(){
    this.health = calculateHealth();
  }

  public double getHealth(){
    return health;
  }

  public int getLevel(){
    return level;
  }

  @Override
  public void printNonReachableMessage() {
    getPrintStream().println("You have encountered a monster, battle will commence");

  }

  public abstract void monsterSpecificAttack(Player p);

  public void battleWithPlayer(Player p){
    monsterSpecificAttack(p);
    double playerAttackDamage = p.getBaseDmg().getPhysDmg();
    boolean battleIsOver = false;

    do {

      p.dealDmg(this, playerAttackDamage);
      if(health < 0){
        printVictoryMessage();
        givePlayerExp(p);
        battleIsOver = true;

      }else{

        dealDmg(p, attackDamage());
        if (p.getHp() < 0){
          printDefeatMessage();
          p.restartGame();
          battleIsOver = true;
        }
      }
    }while(!battleIsOver);
  }

  private void givePlayerExp(Player p) {
    p.gainExp(calculateExpGiven());
  }

  private int calculateExpGiven() {
    return getLevel() + 7;
  }

  private void printDefeatMessage() {
    getPrintStream().println("You died, Game over");
  }

  private void printVictoryMessage() {
    getPrintStream().println("You won the fight!!");
  }
}