package org.example;

public abstract class Item {

    protected String name;
    protected String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void drop(){


    }

    public void interact(){


    }

    public String toString(){

        return name;
    }
}
