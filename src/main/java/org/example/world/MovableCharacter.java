package org.example.world;

import org.example.GameCharacter;
import org.example.Race;

public class MovableCharacter extends GameCharacter{
    public MovableCharacter(String name, Race race) {
        super(name, race);
    }

    private int playerXPos, playerYPos;
    private Room room;

    public void spawnPlayer(World world){
        room = world.getRoom(0);
        room.getTile(1,1).setNonStackableEntity(this);
        playerXPos = 1;
        playerYPos = 1;
    }
    public void despawnPlayer(){
        room.getTile(playerXPos, playerYPos).removeNonStackableEntity();
        room = null;
        playerXPos = -1;
        playerYPos = -1;
    }

    public void moveRight(){
        if (interactWithTile(playerXPos + 1, playerYPos)){
            return;
        }
        room.moveNonStackableEntity(this, playerXPos, playerYPos, playerXPos + 1, playerYPos);
        playerXPos++;

    }
    public void moveLeft(){
        if (interactWithTile(playerXPos - 1, playerYPos)){
            return;
        }
        room.moveNonStackableEntity(this, playerXPos, playerYPos, playerXPos - 1, playerYPos);
        playerXPos--;
    }

    public void moveUp(){
        if (interactWithTile(playerXPos, playerYPos - 1)){
            return;
        }
        room.moveNonStackableEntity(this, playerXPos, playerYPos, playerXPos, playerYPos - 1);
        playerYPos--;
    }

    public void moveDown(){
        if (interactWithTile(playerXPos, playerYPos + 1)){
            return;
        }
        room.moveNonStackableEntity(this, playerXPos, playerYPos, playerXPos, playerYPos + 1);
        playerYPos++;
    }

    private boolean interactWithTile(int x, int y){
        Tile tile = room.getTile(x, y);

        if (tile.getTerrain() instanceof Door d){
            room = changeRoom(d);
            return true;
        }
        if (tile.getTerrain() instanceof Wall){
            System.out.println("There is a wall in the way");
            return true;
        }
        if (tile.getNonStackableEntity() instanceof Stone){
            System.out.println("There is a stone in the way");
            return true;
        }

        return false;
    }

    private Room changeRoom(Door d){

        DoorDirection direction = d.getDirection();
        Room oldRoom = room;
        int oldRoomNumber = oldRoom.getRoomNumber();
        World world = oldRoom.getWorld();
        Room newRoom = null;

        if (direction == DoorDirection.LEFT){
            newRoom = world.getRoom(oldRoom.getRoomNumber() - 1);
            oldRoom.removeNonStackableEntity(playerXPos, playerYPos);
            playerXPos = newRoom.getRightDoorXPos() - 1;
            playerYPos = newRoom.getRightDoorYPos();
            newRoom.setNonStackableEntity(this, playerXPos, playerYPos);
            System.out.println("Walking through door to the left");
        }

        if (direction == DoorDirection.RIGHT){

            try{
                newRoom = world.getRoom(oldRoomNumber + 1);
            }catch (IndexOutOfBoundsException e) {
                world.addRoom();
            }
            newRoom = world.getRoom(oldRoomNumber + 1);
            oldRoom.removeNonStackableEntity(playerXPos, playerYPos);
            playerXPos = newRoom.getLeftDoorXPos() + 1;
            playerYPos = newRoom.getLeftDoorYPos();
            newRoom.setNonStackableEntity(this, playerXPos, playerYPos);
            System.out.println("Walking through door to the right");
        }
        return newRoom;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "P";
    }

}
