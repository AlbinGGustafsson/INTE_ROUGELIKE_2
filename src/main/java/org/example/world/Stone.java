package org.example.world;

public class Stone extends Entity{

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.BLACK + "S" + PrintFormatConstants.RESET;
    }

    @Override
    public void printNonReachableMessage() {
        getPrintStream().println("There is a stone in the way");
    }

}
