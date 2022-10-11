package org.example.world;

public class Wall implements Entity {

    private Position position;

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.BLACK + "#" + PrintFormatConstants.RESET;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public void printNonReachableMessage() {

        System.out.println("There is a wall in the way");
    }
}
