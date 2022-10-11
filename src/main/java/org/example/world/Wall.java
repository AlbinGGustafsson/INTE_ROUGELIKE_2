package org.example.world;

public class Wall implements NonStackableEntity{

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.BLACK + "#" + PrintFormatConstants.RESET;
    }

}
