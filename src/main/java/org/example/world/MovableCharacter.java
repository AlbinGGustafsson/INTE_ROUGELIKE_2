package org.example.world;

import org.example.GameCharacter;
import org.example.Race;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class MovableCharacter extends GameCharacter{

    protected HashSet<Class<? extends Terrain>> terrains = new HashSet<>();

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

        if (interactWithTile(getRoom().getTile(getPosition().getPos(direction)))){
            return;
        }
        getRoom().moveEntity(this, getPosition().getPos(direction));
    }

    public Room changeRoom(Door d){
        Room newRoom = null;
        Position newPos = null;

        if (d.getDirection().equals(Direction.LEFT)){
            newRoom = getRoom().getPreviousRoom();
            newPos = newRoom.getDoor(Direction.RIGHT).getPosition().getPos(Direction.LEFT);
        }
        if (d.getDirection().equals(Direction.RIGHT)){
            newRoom = getRoom().getNextRoom();
            newPos = newRoom.getDoor(Direction.LEFT).getPosition().getPos(Direction.RIGHT);
        }

        getRoom().removeEntity(this);
        newRoom.setEntity(this, newPos);
        d.printWalkThrough();
        return newRoom;
    }

    /**
     * Tries to interact with Tile.
     * returns true if the interaction moved the MovableCharacter.
     */
    protected boolean interactWithTile(Tile tile){
        return false;
    }

    public Set<Class<? extends Terrain>> getTerrains() {
        return Collections.unmodifiableSet(terrains);
    }

}
