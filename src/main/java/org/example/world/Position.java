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

    public Position getRightPos(){
        return new Position(x+1, y);
    }

    public Position getLeftPos(){

        return new Position(x-1, y);
    }
    public Position getUpPos(){

        return new Position(x, y-1);
    }
    public Position getDownPos(){

        return new Position(x, y+1);
    }
}
