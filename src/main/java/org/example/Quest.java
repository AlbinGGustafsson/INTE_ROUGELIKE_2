package org.example;

public class Quest {

    private final String name;
    private final String description;
    private final int XPReward;
    private boolean complete;

    public Quest(String name, String description, int XPReward) {
        this.name = name;
        this.description = description;
        if(XPReward < 0){

            throw new IllegalArgumentException("Quest can't have negative XPReward!");
        }
        this.XPReward = XPReward;
        complete = false;

    }

    public boolean getCompletion(){

        return complete;
    }

    public void setCompletion(boolean b){

        complete = b;
    }



    public String toString(){

        if(complete) {

            return String.format("%s, %s, %d (Completed)", name, description, XPReward);
        }
        return String.format("%s, %s, %d", name, description, XPReward);
    }
}
