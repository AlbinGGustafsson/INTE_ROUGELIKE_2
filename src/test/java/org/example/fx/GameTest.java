package org.example.fx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import org.example.characters.Player;
import org.example.world.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(ApplicationExtension.class)
public class GameTest {

    private static Scene scene;
    private static Stage stage;

    @Start
    private void start(Stage stage) throws IOException {
        GameTest.stage = stage;
        scene = new Scene(loadFXML("characterCreation"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(Parent p) {
        scene.setRoot(p);
        stage.sizeToScene();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameTest.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    @Test
    void test(FxRobot robot) {
        ComboBox raceComboBox = robot.lookup("#raceComboBox").queryComboBox();
        ComboBox characterComboBox = robot.lookup("#charComboBox").queryComboBox();
        TextField nameField = robot.lookup("#nameTextField").queryAs(TextField.class);
        ColorPicker colorPicker = robot.lookup("#colorPicker").queryAs(ColorPicker.class);
        Text appearanceText = robot.lookup("#appearanceText").queryText();

        robot.clickOn(nameField).write("playername");

        robot.clickOn(raceComboBox).clickOn("ORC");
        robot.clickOn(characterComboBox);

        for (int i = 0; i < 20; i++) {
            robot.press(KeyCode.DOWN).release(KeyCode.DOWN);
        }

        robot.clickOn("Q");

        Assertions.assertThat(appearanceText).hasText("Q");

        robot.clickOn(colorPicker);

        for (int i = 0; i < 3; i++) {
            robot.press(KeyCode.DOWN).release(KeyCode.DOWN);
        }

        for (int i = 0; i < 3; i++) {
            robot.press(KeyCode.LEFT).release(KeyCode.LEFT);
        }
        robot.press(KeyCode.ENTER);

        assertEquals(colorPicker.getValue(), appearanceText.getFill());

        robot.clickOn("#newGameButton");

        Label nameLabel = robot.lookup("#nameLabel").queryAs(Label.class);
        Label lvlLabel = robot.lookup("#levelLabel").queryAs(Label.class);
        Label hpLabel = robot.lookup("#hpLabel").queryAs(Label.class);
        Label raceLabel = robot.lookup("#raceLabel").queryAs(Label.class);

        assertEquals("1", lvlLabel.getText());
        assertEquals("0", hpLabel.getText());
        assertEquals("ORC", raceLabel.getText());
        assertEquals("playername", nameLabel.getText());

        TextFlow gameArea = robot.lookup("#gameArea").queryTextFlow();

        List<Node> tileTexts = gameArea.getChildren().stream().toList();

        Player player = null;

        Position position = null;

        for (var node : tileTexts) {
            if (node instanceof TileText) {
                TileText tileText = (TileText) node;

                if (tileText.getTile().getEntity() instanceof Player p) {
                    position = p.getPosition();
                    player = p;

                }
            }
        }

        assertEquals(new Position(1, 1), position);

        assertEquals(colorPicker.getValue(), player.getText().getFill());



    }

}
