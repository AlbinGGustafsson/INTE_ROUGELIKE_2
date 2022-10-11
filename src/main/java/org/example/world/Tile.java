package org.example.world;

import org.example.Item;

public class Tile {

    private Item item;
    private Terrain terrain;
    private Entity entity;

    public Tile(Terrain terrainType) {
        this.terrain = terrainType;
    }

    public Tile(Terrain terrainType, Entity entity) {
        this(terrainType);
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        if (canSetEntity(entity)){
            this.entity = entity;
            return;
        }
        System.err.println("Finns redan en nonstackable eller det är en ogiltig terräng");
    }
    public void removeEntity() {
        entity = null;
    }

    public boolean canSetEntity(Entity entity){

        //Kollar om en movable character kan vara på tilens terräng
        if (entity instanceof MovableCharacter mc && !mc.getTerrains().contains(terrain.getClass())){
            return false;
        }

        return (this.entity == null);
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    @Override
    public String toString() {

        if (entity == null) {
            return terrain.toString();
        }

        return entity.toString();
    }
}
