package org.example.world;

import org.example.GameCharacter;
import org.example.Race;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class MovableCharacter extends GameCharacter{

    private HashSet<Class<? extends Terrain>> terrains = new HashSet<>();

    public MovableCharacter(String name, Race race) {
        super(name, race);
        terrains.add(Floor.class);
    }

    public void addTerrain(Class<? extends Terrain> t){
        terrains.add(t);
    }

    public void removeTerrain(Class<? extends Terrain> t){
        terrains.remove(t);
    }

    public void move(Direction direction){
        if (interactWithTile(getPosition().getPos(direction))){
            return;
        }
        getRoom().moveEntity(this, getPosition().getPos(direction));
    }

    /**
     * Tries to interact with Tile on position.
     * returns true if the interaction moved the MovableCharacter.
     */
    protected abstract boolean interactWithTile(Position position);

    public Set<Class<? extends Terrain>> getTerrains() {
        return Collections.unmodifiableSet(terrains);
    }

}
