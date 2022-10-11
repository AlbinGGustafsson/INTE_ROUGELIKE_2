package org.example.world;

public class Stone implements NonStackableEntity {

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.BLACK + "S" + PrintFormatConstants.RESET;
    }

    @Override
    public void printNonReachableMessage() {

        System.out.println("There is a stone in the way");
    }
}
