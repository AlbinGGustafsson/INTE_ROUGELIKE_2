package org.example.world;

import javafx.scene.text.Text;

import java.io.PrintStream;

public abstract class Terrain {

    private static PrintStream out = new GamePrintStream();

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

    public abstract Text getText();

}
