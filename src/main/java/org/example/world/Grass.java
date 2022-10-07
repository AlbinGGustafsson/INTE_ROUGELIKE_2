package org.example.world;

public class Grass extends Terrain{

    @Override
    public String toString() {
        return "G";
    }

    @Override
    public boolean canAddEntity() {
        return true;
    }
}
