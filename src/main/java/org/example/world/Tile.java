package org.example.world;

import java.util.ArrayList;
import java.util.Optional;

public class Tile {
    private ArrayList<Entity> entities = new ArrayList<>();
    private Terrain terrainType;

    public Tile(Terrain terrainType) {
        this.terrainType = terrainType;
    }

    public void setTerrainType(Terrain terrainType) {
        this.terrainType = terrainType;
    }
    public Terrain getTerrainType() {
        return terrainType;
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void removeEntity(Entity e){
        entities.remove(e);
    }

    public boolean isWalkable(){

        if (!terrainType.isWalkable()){
            return false;
        }
        if (entities.stream().anyMatch(e -> e instanceof NonStackable)){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        Optional<Entity> nonStackableEntity = entities.stream().filter(entity -> entity instanceof NonStackable).findFirst();
        if (nonStackableEntity.isPresent()){
            return nonStackableEntity.get().toString();
        }
            return terrainType.toString();
    }
}
