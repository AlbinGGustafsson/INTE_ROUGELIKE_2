package org.example.world;

import org.example.Helmet;
import org.example.characters.Player;
import org.example.Race;

import java.io.IOException;
import java.util.Scanner;

public class WorldTesting {

    public static void main(String[] args) throws IOException {

        World world = new World();

        world.getRoom(0).setEntity(new Stone(), new Position(5,5));
        Player eloy = new Player("Eloy", Race.HUMAN);
        Player albin = new Player("namn", null , 10);



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
