package org.example.world;

import org.example.GameCharacter;
import org.example.Race;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class MovableCharacter extends GameCharacter{

    private HashSet<Terrain> terrains = new HashSet<>();

    //kanske ska heta något annat än player om andra sker föruom player ska ärva från MovableCharacter
    private int playerXPos, playerYPos;
    private Room room;

    public MovableCharacter(String name, Race race) {
        super(name, race);
        terrains.add(new Floor());
        terrains.add(new LeftDoor());
        terrains.add(new RightDoor());
    }

    //Dessa metoder är väl ändå player specifika
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
    //

    public void addTerrain(Terrain t){
        terrains.add(t);
    }

    public void removeTerrain(Terrain t){
        terrains.remove(t);
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

        if (tile.getTerrain() instanceof Water && !terrains.contains(new Water())){
            System.out.println("You cant swim");
            return true;
        }

        if (tile.getTerrain() instanceof Floor && !terrains.contains(new Floor())){
            System.out.println("You cant go on floor");
            return true;
        }

        if (tile.getTerrain() instanceof Door door){

            if (door instanceof LeftDoor && !terrains.contains(new LeftDoor())){
                System.out.println("You cant use left door");
                return true;
            }

            if (door instanceof RightDoor && !terrains.contains(new RightDoor())){
                System.out.println("You cant use right door");
                return true;
            }
            room = changeRoom(door);
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

        Room oldRoom = room;
        int oldRoomNumber = oldRoom.getRoomNumber();
        World world = oldRoom.getWorld();
        Room newRoom = null;

        if (d instanceof LeftDoor){
            newRoom = world.getRoom(oldRoom.getRoomNumber() - 1);
            oldRoom.removeNonStackableEntity(playerXPos, playerYPos);
            playerXPos = newRoom.getRightDoorXPos() - 1;
            playerYPos = newRoom.getRightDoorYPos();
            newRoom.setNonStackableEntity(this, playerXPos, playerYPos);
            System.out.println("Walking through door to the left");
        }

        if (d instanceof RightDoor){

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

    public Set<Terrain> getTerrains() {
        return Collections.unmodifiableSet(terrains);
    }

    @Override
    public String toString() {
        return PrintFormatConstants.BOLD + PrintFormatConstants.PURPLE + "P" + PrintFormatConstants.RESET;
    }

}
