package org.example;

import org.example.Item;
import org.example.Objective;

import java.util.ArrayList;

public class Quest {

    private String name;
    private String description;
    private ArrayList<Objective> objectives;
    private int XPReward;
    private ArrayList<Item> itemReward;

    public Quest(String name, String description, int XPReward) {
        this.name = name;
        this.description = description;
        this.XPReward = XPReward;
        objectives = new ArrayList<>();
        itemReward = new ArrayList<>();
    }

    public boolean isComplete(){
        for(Objective o: objectives){

            if(o.isComplete() == false){

                return false;
            }
        }

        return true;

    }



    public String toString(){

        return name + "\n\n" + description + "\n\n" + XPReward + "\n\n" + itemReward;
    }
}
