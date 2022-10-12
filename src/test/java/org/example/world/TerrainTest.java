package org.example.world;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TerrainTest {

    @Test
    void weight_Value_Above_Max_Throws_Exception() {

        assertThrows(IllegalArgumentException.class, () -> {
            Terrain t = new Terrain("typeName", 11) {
                @Override
                public void printNonReachableMessage() {
                }
            };
        });
    }

    @Test
    void weight_Value_Below_Min_Throws_Exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            Terrain t = new Terrain("typeName", 0) {
                @Override
                public void printNonReachableMessage() {
                }
            };
        });
    }

    @Test
    void weight_Value_Sets_Correct() {
        Terrain t = new Terrain("typeName", 1) {
            @Override
            public void printNonReachableMessage() {
            }
        };
        assertEquals(1, t.getWeight());
    }

    @Test
    void typeName_Sets_Correct() {
        Terrain t = new Terrain("typeName", 1) {
            @Override
            public void printNonReachableMessage() {
            }
        };
        assertEquals("typeName", t.getTypeName());
    }
}
