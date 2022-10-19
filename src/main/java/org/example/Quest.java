package org.example;

public class Quest {

    private String name;
    private String description;
    private boolean complete;
    private int XPReward;

    public Quest(String name, String description, int XPReward) {
        this.name = name;
        this.description = description;
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
