package org.example.world;

public class Floor extends Terrain{

    public Floor() {
        super("floor", 1);
    }

    @Override
    public String toString() {
        return "F";
    }

    @Override
    public void printNonReachableMessage() {

        System.out.println("You cant go on floor");
    }
}
