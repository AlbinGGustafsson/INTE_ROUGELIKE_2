package org.example.world;

import org.example.Monster.Troll;
import org.example.Player;
import org.example.Race;

import java.io.IOException;
import java.util.Scanner;

public class WorldTesting {

    public static void main(String[] args) throws IOException {

        World world = new World();
        Troll troll = new Troll(10);
        world.getRoom(0).setNonStackableEntity(troll, 1, 2);
        world.getRoom(0).setNonStackableEntity(new Stone(), 5, 5);
        Player eloy = new Player("Eloy", Race.HUMAN);
        eloy.spawnPlayer(world);

        Scanner scanner = new Scanner(System.in);

        System.out.println(eloy.getRoom());
        System.out.println(world);

        while (true){

            int command = scanner.nextInt();
            switch (command){
                case 8:{
                    eloy.moveUp();
                    break;
                }
                case 2:{
                    eloy.moveDown();
                    break;
                }
                case 4:{
                    eloy.moveLeft();
                    break;
                }
                case 6:{
                    eloy.moveRight();
                    break;
                }
            }

            System.out.println(eloy.getRoom());
            System.out.println(world);
        }



    }

}
