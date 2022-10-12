package org.example.world;

public class Stone extends Entity {

    private Position position;

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.BLACK + "S" + PrintFormatConstants.RESET;
    }

    @Override
    public void printNonReachableMessage() {
        System.out.println("There is a stone in the way");
    }
}
