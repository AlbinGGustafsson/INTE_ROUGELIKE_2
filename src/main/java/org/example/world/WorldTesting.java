package org.example.world;

import java.util.Scanner;

public class WorldTesting {

    public static void main(String[] args) {

        World world = new World();


        world.getRoom(0).setNonStackableEntity(new Stone(), 5, 5);
        PlayerExample eloy = new PlayerExample();
        eloy.spawnPlayer(world);

        Scanner scanner = new Scanner(System.in);

        System.out.println(eloy.getRoom());

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
        }



    }

}
