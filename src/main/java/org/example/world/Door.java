package org.example.world;

public abstract class Door extends Terrain{

//    private DoorDirection direction;
    public Door() {
        super("door", 1.5);
//        this.direction = direction;
    }

//    public DoorDirection getDirection() {
//        return direction;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        Door door = (Door) o;
//
//        return direction == door.direction;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + (direction != null ? direction.hashCode() : 0);
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return String.valueOf(direction.toString().charAt(0));
//    }
}
