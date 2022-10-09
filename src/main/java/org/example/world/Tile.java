package org.example.world;

import org.example.Item;
import org.example.Player;

public class Tile {

    private Item item;
    private Terrain terrain;
    private NonStackableEntity nonStackableEntity;

    public Tile(Terrain terrainType) {
        this.terrain = terrainType;
    }

    public NonStackableEntity getNonStackableEntity() {
        return nonStackableEntity;
    }

    public void setNonStackableEntity(NonStackableEntity entity) {
        if (canSetEntity(entity)){
            this.nonStackableEntity = entity;
            return;
        }
        System.err.println("Finns redan en nonstackable eller det är en ogiltig terräng");
    }
    public void removeNonStackableEntity() {
        nonStackableEntity = null;
    }

    public boolean canSetEntity(NonStackableEntity entity){

        //Todo
        //kolla på  den.
        //meiningen är att den ska kolla om något kan vara på en terräng.
//        if (entity instanceof MovableCharacter p && p.getTerrains().contains(terrain.getTypeName())){
//            return true;
//        }
        return !(nonStackableEntity != null || terrain instanceof Solid);
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    @Override
    public String toString() {

        if (nonStackableEntity == null) {
            return terrain.toString();
        }

        return nonStackableEntity.toString();
    }
}
