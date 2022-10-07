package org.example.world;

import java.util.ArrayList;
import java.util.Optional;

public class Tile {
    private ArrayList<Entity> entities = new ArrayList<>();
    private Terrain terrain;

    public Tile(Terrain terrainType) {
        this.terrain = terrainType;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    public Terrain getTerrain() {
        return terrain;
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void removeEntity(Entity e){
        entities.remove(e);
    }

    public boolean canAddEntity(){

        if (!terrain.canAddEntity()){
            return false;
        }
        //Om en tile har en nonStackable entity så går det inte att addera andra entities.
        if (entities.stream().anyMatch(e -> e instanceof NonStackable)){
            return false;
        }
        return true;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        Optional<Entity> nonStackableEntity = entities.stream().filter(entity -> entity instanceof NonStackable || entity instanceof Door).findFirst();
        if (nonStackableEntity.isPresent()){
            return nonStackableEntity.get().toString();
        }
            return terrain.toString();
    }
}
