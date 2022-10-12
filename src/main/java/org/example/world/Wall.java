package org.example.world;

public class Wall extends Entity {

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.BLACK + "#" + PrintFormatConstants.RESET;
    }

    @Override
    public void printNonReachableMessage() {

        System.out.println("There is a wall in the way");
    }
}
