package org.example.world;

public class Wall extends Terrain{

    @Override
    public String toString() {
        return "W";
    }

    @Override
    public boolean isWalkable() {
        return false;
    }
}
