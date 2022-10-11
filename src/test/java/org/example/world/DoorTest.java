package org.example.world;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoorTest {

    @Test
    void constructor_Accepts_Left_Direction(){
        Door door = new Door(Direction.LEFT);
        assertEquals("L", door.toString());
    }

    @Test
    void constructor_Accepts_Right_Direction(){
        Door door = new Door(Direction.RIGHT);
        assertEquals("R", door.toString());
    }

    @Test
    void constructor_Not_Accepting_Up_Direction(){
        assertThrows(IllegalArgumentException.class, () -> new Door(Direction.UP));
    }

    @Test
    void constructor_Not_Accepting_Down_Direction(){
        assertThrows(IllegalArgumentException.class, () -> new Door(Direction.DOWN));
    }

}
