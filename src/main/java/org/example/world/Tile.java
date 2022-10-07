package org.example.world;

import org.example.Item;

import java.util.ArrayList;
import java.util.Optional;

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

    public void setNonStackableEntity(NonStackableEntity nonStackable) {
        if (canAddEntity()){
            this.nonStackableEntity = nonStackable;
            return;
        }
        System.err.println("Finns redan en nonstackable eller det är en ogiltig terräng");
    }
    public void removeNonStackableEntity() {
        nonStackableEntity = null;
    }

    public boolean canAddEntity(){
        return !(nonStackableEntity != null || terrain instanceof NonWalkable);

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
