package org.example.characters;

import org.example.Race;

import java.io.*;
import java.util.Scanner;

public abstract class NPC extends GameCharacter {

    private static final String NPC_DIALOGUE_FOLDER = "NPCFiles/";
    private final File dialogue;
    private final String parsedDialogue;

    private Scanner scanner = new Scanner(System.in);
    protected NPC(String name, Race race, String dialogueFilePath){
        super(name, race);
        dialogue = new File( NPC_DIALOGUE_FOLDER + dialogueFilePath);
        BufferedReader bufferedReader = loadFile();
        parsedDialogue = parseFile(bufferedReader);
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

    public void printDialogueOption(String option){

        getPrintStream().println(option);
    }

    public void printDialogue(){

        getPrintStream().println(parsedDialogue);
    }

    public void setScanner(InputStream in){

        scanner = new Scanner(in);
    }

    public String readPlayerInput(){

        return scanner.nextLine();
    }

    public String getParsedDialogue() {
        return parsedDialogue;
    }

    public File getDialogue() {
        return dialogue;
    }
}

