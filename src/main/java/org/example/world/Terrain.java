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

    public abstract void printNonReachableMessage();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Terrain terrain = (Terrain) o;

        if (Double.compare(terrain.weight, weight) != 0) return false;
        return Objects.equals(typeName, terrain.typeName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
