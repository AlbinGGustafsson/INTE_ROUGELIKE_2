package org.example.world;

public abstract class Door implements NonStackableEntity{

    public abstract void printWalkthru();

    @Override
    public void printNonReachableMessage() {

    }
}
