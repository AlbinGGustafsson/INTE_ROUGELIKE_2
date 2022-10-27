package org.roguelike.world;

import javafx.scene.text.Text;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TerrainTest {

    @Test
    void weight_Value_Above_Max_Throws_Exception() {

        assertThrows(IllegalArgumentException.class, () -> {
            Terrain terrain = new Terrain("typeName", 11) {
                @Override
                public void printNonReachableMessage() {
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

            };
        });
    }

    @Test
    void weight_Value_Sets_Correct() {
        Terrain terrain = new Terrain("typeName", 1) {
            @Override
            public void printNonReachableMessage() {
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

        };
        assertEquals("typeName", terrain.getTypeName());
    }

    @Test
    void getText_returns_Text_Correct_Text(){
        Terrain terrain = new Terrain("typeName", 1) {
            @Override
            public void printNonReachableMessage() {

            }
        };
        Text text = new Text("T");
        assertEquals(text.getText(), terrain.getText().getText(), "Wrong text");
    }
}
