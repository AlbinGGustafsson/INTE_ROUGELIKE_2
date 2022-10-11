package org.example.world;

public class Water extends Terrain {

    public Water() {
        super("water", 2);
    }
    @Override
    public String toString() {
        return PrintFormatConstants.BLUE + "W" + PrintFormatConstants.BOLD;
    }
}
