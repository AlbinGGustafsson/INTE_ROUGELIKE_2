package org.example.world;

public class PlayerExample implements NonStackableEntity {

    private int xPos, yPos;
    private Room room;

    public PlayerExample(int x, int y, Room room) {
        this.xPos = x;
        this.yPos = y;
        this.room = room;
        room.addNonStackableEntity(this, x, y);
    }

    public void moveUp(){
        if (worldInteraction(xPos, yPos - 1)) {
            return;
        }
        room.removeNonStackableEntity(xPos, yPos);
        room.addNonStackableEntity(this, xPos, yPos - 1);
        yPos = yPos - 1;
    }
    public void moveDown(){
        if (worldInteraction(xPos, yPos + 1)) {
            return;
        }
        room.removeNonStackableEntity(xPos, yPos);
        room.addNonStackableEntity(this, xPos, yPos + 1);
        yPos = yPos + 1;
    }

    public void moveRight() {
        if (worldInteraction(xPos + 1, yPos)) {
            return;
        }
        room.removeNonStackableEntity(xPos, yPos);
        room.addNonStackableEntity(this, xPos + 1, yPos);
        xPos = xPos + 1;
    }

    public void moveLeft() {
        if (worldInteraction(xPos - 1, yPos)) {
            return;
        }
        room.removeNonStackableEntity(xPos, yPos);
        room.addNonStackableEntity(this, xPos - 1, yPos);
        xPos = xPos - 1;
    }

    private boolean worldInteraction(int x, int y) {
        Tile tile = room.getTile(x, y);
        if (tile.getTerrain() instanceof Door d) {
            changeRoom(d.getDirection(), room.getX(), room.getY());
            return true;
        }
        if (tile.getTerrain() instanceof Wall) {
            System.out.println("Its a wall in the way");
            return true;
        }
        if (tile.getNonStackableEntity() instanceof Stone) {
            System.out.println("Its just a stone");
            return true;
        }

        return false;
    }

    //TODO
    //(room.getRoomHeight() - 3) är uträkning för vart man ska hamna i nästa rum...
    //addNonStackableEntity kanske borde kasta ett exception om jag ska ha void rum
    private void changeRoom(Direction direction, int roomX, int roomY) {
        room.removeNonStackableEntity(xPos, yPos);
        World world = room.getWorld();

        try {
            if (direction == Direction.NORTH) {
                yPos = yPos + (room.getRoomHeight() - 3);
                room = world.getRoom(roomX, roomY - 1);
                room.addNonStackableEntity(this, xPos, yPos);
                System.out.println("Changing room north");
            }

            if (direction == Direction.SOUTH) {
                yPos = yPos - (room.getRoomHeight() - 3);
                room = world.getRoom(roomX, roomY + 1);
                room.addNonStackableEntity(this, xPos, yPos);
                System.out.println("Changing room south");
            }

            if (direction == Direction.WEST) {
                xPos = xPos + (room.getRoomWidth() - 3);
                room = world.getRoom(roomX - 1, roomY);
                room.addNonStackableEntity(this, xPos, yPos);
                System.out.println("Changing room west");
            }

            if (direction == Direction.EAST) {
                xPos = xPos - (room.getRoomWidth() - 3);
                room = world.getRoom(roomX + 1, roomY);
                room.addNonStackableEntity(this, xPos, yPos);
                System.out.println("Changing room east");
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Återvändsgränd");
        }

    }

    @Override
    public String toString() {
        return "P";
    }
}
