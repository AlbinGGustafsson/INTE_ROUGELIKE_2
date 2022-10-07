package org.example;

public abstract class Quest {

    private String name;
    private String description;
    private int XPReward;
    private Item[] itemReward;

    public Quest(String name, String description, int XPReward, Item[] itemReward) {
        this.name = name;
        this.description = description;
        this.XPReward = XPReward;
        this.itemReward = itemReward;
    }
}
