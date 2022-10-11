package org.example.world;

public class LeftDoor extends Door {

    @Override
    public String toString() {
        return "L";
    }

    @Override
    public void printWalkthru() {

        System.out.println("Walking through door to the left");
    }
}
