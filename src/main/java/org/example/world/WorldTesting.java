package org.example.world;


import org.example.*;
import org.example.characters.NPC;
import org.example.characters.Player;
import org.example.characters.QuestGiver;
import org.example.characters.Vendor;

import org.example.Helmet;
import org.example.Monster.Troll;
import org.example.Race;


import java.io.IOException;
import java.util.Scanner;

public class WorldTesting {

    public static void main(String[] args) throws IOException {

        GamePrintStream gamePrintStream = new GamePrintStream();
        gamePrintStream.println("hej");
        gamePrintStream.println("hej2");
        gamePrintStream.println("hej3");

        System.out.println(GamePrintStream.getGameText());


        World world = new World();

        world.getRoom(0).setEntity(new Stone(), new Position(5,5));
        Player eloy = new Player("Eloy", Race.HUMAN);

        NPC jonas = new QuestGiver("Jonas", Race.HUMAN, "JonasTestDialog.txt", new Quest("Hitta nemo", "Simma runt lite", 5));
        NPC albin = new Vendor("Albin", Race.ELF, "AlbinDialog.txt");

        world.getRoom(0).setEntity(jonas, new Position(5,6));
        world.getRoom(0).setEntity(albin, new Position(5,7));

        Troll troll = new Troll(10);
        world.spawnPlayer(eloy);
        System.out.println(eloy.getHp());
        System.out.println(eloy.getLevel());


        world.spawnPlayer(eloy);


        eloy.addTerrain(Water.class);

        world.getRoom(0).setEntity(eloy, new Position(1,1));
        world.getRoom(0).setEntity(troll, new Position(3, 4));



        //world.spawnPlayer(eloy);

        eloy.addTerrain(Water.class);
        //System.out.println(eloy.getPosition());

        world.getRoom(0).getTile(new Position(1,0)).addItem(new Helmet("Hjälm", "Skyddar huvudet", 100, 300));

        Scanner scanner = new Scanner(System.in);

        System.out.println(world.getRoom(0));
        System.out.println(world);


        while (true){

            int command = scanner.nextInt();
            switch (command){
                case 8:{
                    eloy.move(Direction.UP);
                    break;
                }
                case 2:{
                    eloy.move(Direction.DOWN);
                    break;
                }
                case 4:{
                    eloy.move(Direction.LEFT);
                    break;
                }
                case 6:{
                    eloy.move(Direction.RIGHT);
                    break;
                }
            }


            System.out.println(eloy.getRoom());
            System.out.println(world);
            System.out.println(eloy.getQuestLog().toString());

        }

    }

}
