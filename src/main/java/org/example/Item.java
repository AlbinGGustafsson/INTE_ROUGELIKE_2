package org.example;

import java.util.Objects;

public abstract class Item {

    protected String name;
    protected String description;

    public Item(String name, String description) {
        Objects.requireNonNull(this.name = name);
        Objects.requireNonNull(this.description = description);
    }

    public void drop(){


    }

    public void interact(){


    }

    public String toString(){

        return name;
    }
}
