package org.example.characters;

import org.example.Race;
import org.example.world.MovableCharacter;

import java.io.*;
import java.util.Scanner;

public abstract class NPC extends MovableCharacter {

    private File dialogue;
    private String parsedDialogue;
    public NPC(String name, Race race, String dialogueFilePath){
        super(name, race);
        dialogue = new File("NPCFiles/" + dialogueFilePath);
        BufferedReader bufferedReader = loadFile();
        parsedDialogue = parseFile(bufferedReader);
    }

    protected void printDialogue(){

        getPrintStream().println(parsedDialogue);
    }

    private BufferedReader loadFile(){

        FileReader fileReader;
        try {
            fileReader = new FileReader(dialogue);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new BufferedReader(fileReader);
    }
    private String parseFile(BufferedReader bufferedReader){

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

    public abstract void interact(Player player);

    public void showDialogueOption(String option){

        getPrintStream().println(option);
    }

    public String readPlayerInput(){

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        return command;
    }

    public String getParsedDialogue() {
        return parsedDialogue;
    }
}
