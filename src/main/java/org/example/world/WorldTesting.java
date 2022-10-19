package org.example.world;


import org.example.*;
import org.example.Monster.Troll;
import org.example.characters.Player;
import org.example.characters.QuestGiver;
import org.example.characters.Vendor;

import org.example.Helmet;
import org.example.characters.Player;
import org.example.Race;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorldTesting {

    public static void main(String[] args) throws IOException {

        World world = new World();

        world.getRoom(0).setEntity(new Stone(), new Position(5,5));
        Player eloy = new Player("Eloy", Race.HUMAN);

        VendorItem spade = new VendorItem("Spade", "Kan gräva", 10);
        VendorItem hammare = new VendorItem("Hammare", "Kan slå", 5);

        QuestGiver jonas = new QuestGiver("Jonas", Race.HUMAN, "TestDialog2.txt", new Quest("Hitta nemo", "Simma runt lite", 5));
        Vendor albin = new Vendor("Albin", Race.ELF, "TestDialog1.txt", new ArrayList<>(List.of(spade, hammare)));

        world.getRoom(0).setEntity(jonas, new Position(5,6));
        world.getRoom(0).setEntity(albin, new Position(5,7));

        Troll troll = new Troll(10);
        world.spawnPlayer(eloy);
        System.out.println(eloy.getHp());
        System.out.println(eloy.getLevel());


        world.spawnPlayer(eloy);


        eloy.addTerrain(Water.class);

        world.getRoom(0).setEntity(eloy, new Position(1,1));



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
        }

    }

}
