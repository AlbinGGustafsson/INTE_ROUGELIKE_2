package org.example;

import java.util.Objects;

public class VendorItem extends Item {

    private int value;

    public VendorItem(String name, String description, int value){

        super(name, description);
        this.value = Objects.requireNonNull(value);
    }

    public int getValue() {
        return value;
    }

    public String toString(){

        return String.format("[%s, %d]", super.getName(), value);
    }

}
