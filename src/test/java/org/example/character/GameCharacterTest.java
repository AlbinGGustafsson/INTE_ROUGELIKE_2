package org.example.character;

import org.example.Race;
import org.example.characters.GameCharacter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameCharacterTest {

    @Test
    void printNonReachableMessagePrintsRightMessage(){

        GameCharacter gameCharacter = new GameCharacter("name", Race.HUMAN){};

        OutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        gameCharacter.setPrintStream(out);

        gameCharacter.printNonReachableMessage();

        assertThat(output.toString().trim(), equalTo("Can't walk on character"));
    }
}
