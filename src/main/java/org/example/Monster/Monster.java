package org.example.Monster;

abstract class Monster  {

    //private String[] terrainType;
      private final int level;
      private int health;


      public Monster(int level){
        if(level < 1){
          throw new IllegalArgumentException();
        }
           this.level = level;
           setHealth();
      }

      public abstract int calculateHealth();

      public abstract void die();

      public abstract double attackDamage();

      public abstract void attack();

      private void setHealth(){
        this.health = calculateHealth();
      }

      public int getHealth(){
        return health;
      }

      public int getLevel(){
        return level;
      }

}
