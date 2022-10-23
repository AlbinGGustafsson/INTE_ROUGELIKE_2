package org.example.world;

import javafx.scene.text.Text;
import org.example.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tile {

    private ArrayList<Item> items = new ArrayList<>();
    private Terrain terrain;
    private Entity entity;

    public Tile(Terrain terrainType) {
        this.terrain = terrainType;
    }

    public Tile(Terrain terrainType, Entity entity) {
        this(terrainType);
        setEntity(entity);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void removeAllItems() {
        items.clear();
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        if (canSetEntity(entity)){
            this.entity = entity;
        }
    }

    public void setTerrain(Terrain terrain){
        this.terrain = terrain;
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

        if (this.entity != null) {
            //this.entity.printNonReachableMessage();
            return false;
        }
        return true;
    }
    public Terrain getTerrain() {
        return terrain;
    }



    public Text getText(){
        if (entity != null) {
            return entity.getText();
        }

        if (!items.isEmpty()){
            return new Text("I");
        }
        return terrain.getText();
    }

    @Override
    public String toString() {

        if (entity != null) {
            return entity.toString();
        }

        if (!items.isEmpty()){
            return items.get(0).toString();
        }
        return terrain.toString();

    }
}
