package org.example.Monster;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.example.BaseDamage;
import org.example.Combat;
import org.example.Player;
import org.example.world.Entity;
import org.example.world.Position;

public abstract class Monster extends Entity implements Combat {

  //private String[] terrainType;
  private final int level;
  private double health;

  private Position position;


  public Monster(int level){
    if(level < 1){
      throw new IllegalArgumentException();
    }
    this.level = level;
    setHealth();
  }

  @Override
  public BaseDamage getBaseDmg() {
    return null;
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

  public abstract void die();

  public abstract double attackDamage();

  public abstract void attack();

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

  public void battleWithPlayer(Player p){
    double playerHealth = p.getHp();
    double playerAttackDamage = 100;
    boolean battleIsOver = false;

    do {

      dealDmg(this, playerAttackDamage);
      if(health < 0){
        printVictoryMessage();
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

  private void printDefeatMessage() {
    getPrintStream().println("You died, Game over");
  }

  private void printVictoryMessage() {
    getPrintStream().println("You won the fight!!");
  }

}
