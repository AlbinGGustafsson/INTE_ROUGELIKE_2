package org.example.Monster;

import org.example.Player;
import org.example.world.MovableCharacter;
import org.example.world.NonStackableEntity;

public abstract class Monster implements NonStackableEntity {

    //private String[] terrainType;
      private final int level;
      private double health;


      public Monster(int level){
        if(level < 1){
          throw new IllegalArgumentException();
        }
           this.level = level;
           setHealth();
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

      public boolean battleWithPlayer(Player p){
          double playerHealth = p.getHealth();
          double playerAttackDamage = p.getAttackDamage();
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
