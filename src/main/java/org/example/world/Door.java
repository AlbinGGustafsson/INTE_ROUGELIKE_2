package org.example.world;

public class Door extends Entity implements NonStackable{

    private Direction direction;
    private Room room;

    public Door(Room room, int x, int y) {
        this.room = room;
        if (y == 0){
            direction = Direction.NORTH;
        }
        if (y == room.getRoomHeight()-1){
            direction = Direction.SOUTH;
        }
        if (x == 0){
            direction = Direction.WEST;
        }
        if (x == room.getRoomWidth()-1){
            direction = Direction.EAST;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "D";
    }



}
