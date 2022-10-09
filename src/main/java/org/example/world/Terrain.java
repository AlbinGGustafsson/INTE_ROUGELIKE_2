package org.example.world;

import java.util.Objects;

abstract class Terrain {

    private double weight;
    private String typeName;
    public Terrain(String typeName, double weight) {
        this.weight = weight;
        this.typeName = typeName;
    }

    public double getWeight() {
        return weight;
    }

    public String getTypeName() {
        return typeName;
    }
}
