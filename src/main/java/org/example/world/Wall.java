package org.example.world;

public class Wall extends Terrain implements Solid {

    public Wall() {
        super("wall", 1);
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.BLACK + "#" + PrintFormatConstants.RESET;
    }


}
