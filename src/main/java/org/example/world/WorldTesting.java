package org.example.world;

import org.example.Monster.Troll;
import org.example.Player;
import org.example.Race;

import java.io.IOException;
import java.util.Scanner;

public class WorldTesting {

    public static void main(String[] args) throws IOException {

        World world = new World();


        world.getRoom(0).setEntity(new Stone(), new Position(5,5));
        Troll troll = new Troll(10);
        world.getRoom(0).setEntity(troll, new Position(5,5));
        world.getRoom(0).setEntity(new Stone(), new Position(5,5));

        Player eloy = new Player("Eloy", Race.HUMAN);
        world.spawnPlayer(eloy);
        eloy.addTerrain(Water.class);

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
