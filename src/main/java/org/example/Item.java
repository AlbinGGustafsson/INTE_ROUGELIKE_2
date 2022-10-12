package org.example;

import java.util.Objects;

public abstract class Item {

    protected String name;
    protected String description;

    public Item(String name, String description) {
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
    }

    public void drop(){


    }

    public void interact(){


    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "I";
    }
}
