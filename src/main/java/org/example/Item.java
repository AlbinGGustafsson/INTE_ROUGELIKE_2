package org.example;

import java.util.Objects;

public abstract class Item {

    private final String name;
    private final String description;

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
