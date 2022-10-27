package org.roguelike.world;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {

        if (x < 0 || y < 0){
            throw new IllegalArgumentException("Position values has to be >= 0");
        }

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
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("Pos x(%d), y(%d)", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
