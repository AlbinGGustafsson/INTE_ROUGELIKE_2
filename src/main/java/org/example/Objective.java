package org.example;

//Denna klass kanske inte behövs utan objectives kan bara representeras
//av strängar som ändras när dem blir uppfyllda

public class Objective {

    private String description;
    private Boolean complete; //den här e sketch men låter den va för nu

    public Objective(String description) {
        this.description = description;
    }

    public Boolean isComplete(){

        return complete;
    }

    public String toString(){

        if(complete){

            return description + " 1/1";
        }

        return description + " 0/1";
    }
}
