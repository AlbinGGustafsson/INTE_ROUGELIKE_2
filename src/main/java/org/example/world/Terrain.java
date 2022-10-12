package org.example.world;

import java.io.PrintStream;

abstract class Terrain {

    private static PrintStream out = System.out;

    private int weight;
    private String typeName;
    public Terrain(String typeName, int weight) {

        if (weight < 1 || weight > 10){
            throw new IllegalArgumentException();
        }

        this.weight = weight;
        this.typeName = typeName;
    }

    public double getWeight() {
        return weight;
    }

    public String getTypeName() {
        return typeName;
    }

    public  void setPrintStream(PrintStream out){
        this.out = out;
    }

    public PrintStream getPrintStream() {
        return out;
    }

    public abstract void printNonReachableMessage();

}
