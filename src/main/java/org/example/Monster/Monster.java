package org.example.Monster;

import org.example.BaseDamage;
import org.example.Combat;
import org.example.Player;
import org.example.world.Entity;
import org.example.world.Position;

public abstract class Monster implements Entity, Combat {

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
    public void dealDmg(Combat combatTarget, int damage) {
        Combat.super.dealDmg(combatTarget, damage);
    }

    @Override
    public boolean blocked() {
        return Combat.super.blocked();
    }

    @Override
    public void takeDmg(int damage) {

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
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {

    }

    @Override
    public void printNonReachableMessage() {

    }

    public boolean battleWithPlayer(Player p){
          double playerHealth = p.getHp();
          double playerAttackDamage = p.getBaseDmg().getPhysDmg();
          double monsterAttackDamage = attackDamage();
          boolean battleIsOver = false;

          do {

            health = health - playerAttackDamage;
            if(health < 0){
              battleIsOver = true;
              System.out.println(health);
            }else {

              playerHealth = playerHealth - monsterAttackDamage;
              System.out.println(playerHealth);
              if (playerHealth < 0) {
                battleIsOver = true;
              }
            }
          }while(!battleIsOver);

          if(playerHealth > 0){
            System.out.println("You won the fight!");
              System.out.println("Your current health " + playerHealth);
              return true;
          }else{
            System.out.println("Bruh you died");
            return false;
          }
      }

}
