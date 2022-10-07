package org.example.Monster;

abstract class Monster  {

    //private String[] terrainType;
      private int level;
      private int health;


      public Monster(int level){
           this.level = level;
           setHealth();
      }

      public abstract int calculateHealth();

      public abstract void die();

      public abstract int attackDamage();

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
