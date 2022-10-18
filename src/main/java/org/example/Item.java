package org.example;

import java.util.Objects;

public abstract class Item {

    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "I";
    }
}
