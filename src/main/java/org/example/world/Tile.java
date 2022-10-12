package org.example.world;

import org.example.Item;

import java.util.ArrayList;

public class Tile {

    private ArrayList<Item> items = new ArrayList<>();
    private Terrain terrain;
    private Entity entity;

    public Tile(Terrain terrainType) {
        this.terrain = terrainType;
    }

    public Tile(Terrain terrainType, Entity entity) {
        this(terrainType);
        this.entity = entity;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
            this.entity = entity;
    }

    public void removeEntity() {
        entity = null;
    }

    public boolean canSetEntity(Entity entity) {

        //Kollar om en movable character kan vara på tilens terräng
        if (entity instanceof MovableCharacter mc && !mc.getTerrains().contains(terrain.getClass())) {
            //terrain.printNonReachableMessage();
            return false;
        }

        if (this.entity != null){
            //this.entity.printNonReachableMessage();
            return false;
        }
        return true;
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
