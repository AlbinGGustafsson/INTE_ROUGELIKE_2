package org.example.fx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import org.example.characters.Player;
import org.example.world.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ExtendWith(ApplicationExtension.class)
public class GameTest {

    private static Scene scene;
    private static Stage stage;

    private Label nameLabel;
    private Label lvlLabel;
    private Label hpLabel;
    private Label raceLabel;

    private ComboBox raceComboBox;
    private ComboBox characterComboBox;
    private TextField nameField;
    private ColorPicker colorPicker;
    private Text appearanceText;
    private TextFlow gameArea;


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

    @BeforeEach
    void findUsefulComponentsCharacterCreation(FxRobot robot){
        raceComboBox = robot.lookup("#raceComboBox").queryComboBox();
        characterComboBox = robot.lookup("#charComboBox").queryComboBox();
        nameField = robot.lookup("#nameTextField").queryAs(TextField.class);
        colorPicker = robot.lookup("#colorPicker").queryAs(ColorPicker.class);
        appearanceText = robot.lookup("#appearanceText").queryText();
    }

    private void findUsefulComponentsGame(FxRobot robot){
        nameLabel = robot.lookup("#nameLabel").queryAs(Label.class);
        lvlLabel = robot.lookup("#levelLabel").queryAs(Label.class);
        hpLabel = robot.lookup("#hpLabel").queryAs(Label.class);
        raceLabel = robot.lookup("#raceLabel").queryAs(Label.class);
        gameArea = robot.lookup("#gameArea").queryTextFlow();
    }

    private TileText getPlayerTileText(){
        TileText tileText = null;

        List<Node> tileTexts = gameArea.getChildren().stream().toList();

        for (var node : tileTexts) {
            if (node instanceof TileText tt) {
                if (tt.getTile().getEntity() instanceof Player) {
                    tileText = tt;
                }
            }
        }
        return tileText;
    }

    private Player getPlayer(){
        if (getPlayerTileText() != null){
            return (Player) getPlayerTileText().getTile().getEntity();
        }
        return null;
    }

    @Test
    void nameField_Correct_Others_Default_Everything_Correct_In_Game(FxRobot robot){
        robot.clickOn(nameField).write("playername");

        robot.clickOn("#newGameButton");

        findUsefulComponentsGame(robot);

        assertEquals("1", lvlLabel.getText());
        assertEquals("0", hpLabel.getText());
        assertEquals("HUMAN", raceLabel.getText());
        assertEquals("playername", nameLabel.getText());

        //hmm egna test eller inte alls
        assertEquals(colorPicker.getValue(), getPlayerTileText().getFill());
        assertEquals(new Position(1,1), Objects.requireNonNull(getPlayer()).getPosition());
    }

    @Test
    void nameField_Correct_Others_Changed_Everything_Correct_In_Game(FxRobot robot){
        robot.clickOn(nameField).write("playername");
        robot.clickOn(raceComboBox).clickOn("ORC");
        robot.clickOn(characterComboBox).clickOn("F");
        robot.clickOn(colorPicker);

        for (int i = 0; i < 3; i++) {
            robot.press(KeyCode.DOWN).release(KeyCode.DOWN);
            robot.press(KeyCode.LEFT).release(KeyCode.LEFT);
        }
        robot.press(KeyCode.ENTER);

        robot.clickOn("#newGameButton");

        findUsefulComponentsGame(robot);

        assertEquals("1", lvlLabel.getText());
        assertEquals("0", hpLabel.getText());
        assertEquals("ORC", raceLabel.getText());
        assertEquals("playername", nameLabel.getText());

        //hmm egna test eller inte alls
        assertEquals(colorPicker.getValue(), getPlayerTileText().getFill());
        assertEquals(new Position(1,1), Objects.requireNonNull(getPlayer()).getPosition());
    }

    @Test
    void changed_Character_Appearance_Showed_Correctly_Real_Time(FxRobot robot){
        robot.clickOn(characterComboBox).clickOn("B");
        String correctCharacterAsString = characterComboBox.getSelectionModel().getSelectedItem().toString();
        Assertions.assertThat(appearanceText).hasText(correctCharacterAsString);
    }

    @Test
    void changed_Color_Appearance_Showed_Correctly_Real_Time(FxRobot robot){
        robot.clickOn(colorPicker);
        for (int i = 0; i < 5; i++) {
            robot.press(KeyCode.DOWN).release(KeyCode.DOWN);
            robot.press(KeyCode.LEFT).release(KeyCode.LEFT);
        }
        robot.press(KeyCode.ENTER);
        assertEquals(colorPicker.getValue(), appearanceText.getFill());
    }

    @Test
    void name_Field_Empty_Gives_Alert_With_Correct_Message(FxRobot robot){
        robot.clickOn("#newGameButton");
        DialogPane dialogPane = robot.lookup("#nameInputDialog").queryAs(DialogPane.class);
        String headerText = dialogPane.getHeaderText();
        Assertions.assertThat(headerText).contains("name").contains("empty");
        robot.clickOn(dialogPane.lookupButton(ButtonType.OK));
    }


    @Test
    void name_Field_Too_Long_Gives_Alert_With_Correct_Message(FxRobot robot){
        robot.clickOn(nameField).write("anameover20characters");
        robot.clickOn("#newGameButton");
        DialogPane dialogPane = robot.lookup("#nameInputDialog").queryAs(DialogPane.class);
        String headerText = dialogPane.getHeaderText();
        Assertions.assertThat(headerText).contains("20").contains("name");
        robot.clickOn(dialogPane.lookupButton(ButtonType.OK));
    }

}
