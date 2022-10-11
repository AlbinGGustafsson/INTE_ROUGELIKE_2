package org.example.world;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public Position getPos(Direction direction){
        switch (direction){
            case UP -> {
                return new Position(x, y-1);
            }
            case DOWN ->{
                return new Position(x, y+1);
            }
            case LEFT -> {
                return new Position(x-1, y);
            }
            case RIGHT -> {
                return new Position(x+1, y);
            }
            case UP_LEFT -> {
                return new Position(x-1, y-1);
            }
            case UP_RIGHT -> {
                return new Position(x+1, y-1);
            }
            case DOWN_LEFT -> {
                return new Position(x-1, y+1);
            }
            case DOWN_RIGHT -> {
                return new Position(x+1, y+1);
            }
            default -> {
                return null;
            }
        }
    }
}
