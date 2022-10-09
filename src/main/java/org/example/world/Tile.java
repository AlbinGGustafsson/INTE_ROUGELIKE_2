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

        //Kollar om en movable character kan vara på tilens terräng
        if (entity instanceof MovableCharacter mc && !mc.getTerrains().contains(terrain)){
            return false;
        }

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
