package org.example.characters;

import org.example.Race;
import org.example.world.MovableCharacter;
import org.example.world.Tile;

import java.io.*;
import java.util.Scanner;

public abstract class NPC extends MovableCharacter {

    private File dialogue;
    private String parsedDialogue;
    protected NPC(String name, Race race, String dialogueFilePath){
        super(name, race);
        dialogue = new File("NPCFiles/" + dialogueFilePath);
        BufferedReader bufferedReader = loadFile();
        parsedDialogue = parseFile(bufferedReader);
    }

    protected void printDialogue(){

        getPrintStream().println(parsedDialogue);
    }

    BufferedReader loadFile(){

        FileReader fileReader;
        try {
            fileReader = new FileReader(dialogue);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new BufferedReader(fileReader);
    }
    String parseFile(BufferedReader bufferedReader){

        String line;

        StringBuilder sb = new StringBuilder();

        try{
            while(((line = bufferedReader.readLine()) != null)){

                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    protected boolean interactWithTile(Tile tile){


        return false;
    }

    protected abstract void interact(Player player);

    String dialogueOption(String option){

        Scanner scanner = new Scanner(System.in);

        getPrintStream().println(option);
        String command = scanner.nextLine();

        return command;
    }

}
