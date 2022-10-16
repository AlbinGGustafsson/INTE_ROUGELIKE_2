package org.example;

import org.example.world.MovableCharacter;
import org.example.world.PrintFormatConstants;
import org.example.world.Tile;

import java.io.*;

public abstract class NPC extends MovableCharacter {

    private File dialogue;
    private String parsedDialogue;
    protected NPC(String name, Race race, String filePath){
        super(name, race);
        dialogue = new File("NPCFiles/" + filePath);
        BufferedReader bufferedReader = loadFile();
        parsedDialogue = parseFile(bufferedReader);
    }

    protected void printDialogue(){

        getPrintStream().println(PrintFormatConstants.BOLD + PrintFormatConstants.PURPLE + parsedDialogue + PrintFormatConstants.RESET);
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
}
