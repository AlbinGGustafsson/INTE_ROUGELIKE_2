package org.roguelike.world;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    void x_Sets_Correct(){
        Position position = new Position(1,2);
        assertEquals(1, position.getX());
    }

    @Test
    void y_Sets_Correct(){
        Position position = new Position(2,1);
        assertEquals(1, position.getY());
    }

    @Test
    void negative_X_Throws_Exception(){
        assertThrows(IllegalArgumentException.class, () -> new Position(-1, 1));
    }

    @Test
    void negative_Y_Throws_Exception(){
        assertThrows(IllegalArgumentException.class, () -> new Position(1, -1));
    }


    @Test
    void getPos_Up(){
        Position position = new Position(5,5);
        assertEquals(new Position(5,4), position.getPos(Direction.UP));
    }

    @Test
    void getPos_Down(){
        Position position = new Position(5,5);
        assertEquals(new Position(5,6), position.getPos(Direction.DOWN));
    }

    @Test
    void getPos_Left(){
        Position position = new Position(5,5);
        assertEquals(new Position(4,5), position.getPos(Direction.LEFT));
    }

    @Test
    void getPos_Right(){
        Position position = new Position(5,5);
        assertEquals(new Position(6,5), position.getPos(Direction.RIGHT));
    }

    @Test
    void getPos_UP_LEFT(){
        Position position = new Position(5,5);
        assertEquals(new Position(4,4), position.getPos(Direction.UP_LEFT));
    }

    @Test
    void getPos_UP_RIGHT(){
        Position position = new Position(5,5);
        assertEquals(new Position(6,4), position.getPos(Direction.UP_RIGHT));
    }

    @Test
    void getPos_Down_Left(){
        Position position = new Position(5,5);
        assertEquals(new Position(4,6), position.getPos(Direction.DOWN_LEFT));
    }

    @Test
    void getPos_Down_Right(){
        Position position = new Position(5,5);
        assertEquals(new Position(6,6), position.getPos(Direction.DOWN_RIGHT));
    }

    @Test
    void toString_Is_Correct(){
        assertEquals("Pos x(1), y(2)", new Position(1,2).toString());
    }

    @Test
    void same_X_And_Y_Value_Equals_True(){
        assertEquals(new Position(1,2), new Position(1,2));
    }

    @Test
    void same_X_And_Y_Value_Equal_HashCode(){
        assertEquals(new Position(1,2).hashCode(), new Position(1,2).hashCode());
    }
}
