package org.example.world;

import javafx.geometry.Pos;
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

    public void moveRight(){
        if (interactWithTile(getPosition().getRightPos())){
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

    protected abstract boolean interactWithTile(Position position);

    public Set<Class<? extends Terrain>> getTerrains() {
        return Collections.unmodifiableSet(terrains);
    }

}
