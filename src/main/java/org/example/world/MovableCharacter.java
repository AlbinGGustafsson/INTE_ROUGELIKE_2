package org.example.world;

import org.example.GameCharacter;
import org.example.Race;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class MovableCharacter extends GameCharacter{

    private HashSet<Terrain> terrains = new HashSet<>();

    public MovableCharacter(String name, Race race) {
        super(name, race);
        terrains.add(new Floor());
        terrains.add(new LeftDoor());
        terrains.add(new RightDoor());
    }

    public void addTerrain(Terrain t){
        terrains.add(t);
    }

    public void removeTerrain(Terrain t){
        terrains.remove(t);
    }

    public void moveRight(){
        if (interactWithTile(getXPos() + 1, getYPos())){
            return;
        }
        getRoom().moveNonStackableEntity(this, getXPos(), getYPos(), getXPos() + 1, getYPos());
        setXPos(getXPos()+1);

    }
    public void moveLeft(){
        if (interactWithTile(getXPos() - 1, getYPos())){
            return;
        }
        getRoom().moveNonStackableEntity(this, getXPos(), getYPos(), getXPos() - 1, getYPos());
        setXPos(getXPos()-1);
    }

    public void moveUp(){
        if (interactWithTile(getXPos(), getYPos() - 1)){
            return;
        }
        getRoom().moveNonStackableEntity(this, getXPos(), getYPos(), getXPos(), getYPos() - 1);
        setYPos(getYPos() - 1);
    }

    public void moveDown(){
        if (interactWithTile(getXPos(), getYPos() + 1)){
            return;
        }
        getRoom().moveNonStackableEntity(this, getXPos(), getYPos(), getXPos(), getYPos() + 1);
        setYPos(getYPos() + 1);
    }

    protected abstract boolean interactWithTile(int x, int y);

    public Set<Terrain> getTerrains() {
        return Collections.unmodifiableSet(terrains);
    }

}
