package org.example.world;

public class Wall extends Terrain implements NonWalkable{

    @Override
    public String toString() {
        return "W";
    }

}