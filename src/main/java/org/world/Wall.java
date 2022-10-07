package org.world;

public class Wall extends Terrain{

    @Override
    public String toString() {
        return "W";
    }

    @Override
    public boolean canAddEntity() {
        return false;
    }
}
