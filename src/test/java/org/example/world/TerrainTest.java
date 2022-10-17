package org.example.world;

import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TerrainTest {

    @Test
    void weight_Value_Above_Max_Throws_Exception() {

        assertThrows(IllegalArgumentException.class, () -> {
            Terrain terrain = new Terrain("typeName", 11) {
                @Override
                public void printNonReachableMessage() {
                }

                @Override
                public Text getText() {
                    return new Text("T");
                }
            };
        });
    }

    @Test
    void weight_Value_Below_Min_Throws_Exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            Terrain terrain = new Terrain("typeName", 0) {
                @Override
                public void printNonReachableMessage() {
                }

                @Override
                public Text getText() {
                    return new Text("T");
                }
            };
        });
    }

    @Test
    void weight_Value_Sets_Correct() {
        Terrain terrain = new Terrain("typeName", 1) {
            @Override
            public void printNonReachableMessage() {
            }

            @Override
            public Text getText() {
                return new Text("T");
            }
        };
        assertEquals(1, terrain.getWeight());
    }

    @Test
    void typeName_Sets_Correct() {
        Terrain terrain = new Terrain("typeName", 1) {
            @Override
            public void printNonReachableMessage() {
            }

            @Override
            public Text getText() {
                return new Text("T");
            }
        };
        assertEquals("typeName", terrain.getTypeName());
    }
}
