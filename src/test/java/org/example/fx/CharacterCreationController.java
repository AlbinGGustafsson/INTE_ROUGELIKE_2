package org.example.fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.example.Player;
import org.example.Race;
import org.example.world.World;

import java.io.IOException;
import java.util.Arrays;

public class CharacterCreationController {


    private static final String CHARACTERS_TO_CHOOSE_FROM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @FXML
    private Button newGameButton;

    @FXML
    private TextFlow appearanceTextFlow;
    @FXML
    private TextField nameTextField;

    @FXML
    private ComboBox raceComboBox;

    @FXML
    private ComboBox charComboBox;

    @FXML
    private Text appearanceText;


    @FXML
    public void initialize() {

        ObservableList<Race> races = FXCollections.observableList(Arrays.asList(Race.class.getEnumConstants()));
        raceComboBox.setItems(races);
        raceComboBox.getSelectionModel().select(0);

        Character[] characterArray = CHARACTERS_TO_CHOOSE_FROM.chars().mapToObj(x -> (char) x).toArray(Character[]::new);
        ObservableList<Character> characters = FXCollections.observableArrayList(characterArray);
        charComboBox.setItems(characters);
        charComboBox.getSelectionModel().select(0);

        appearanceText.setText(charComboBox.getSelectionModel().getSelectedItem().toString());

    }
    @FXML
    void createNewGame(ActionEvent event) throws IOException {
        World world = new World();
        Player player = new Player(nameTextField.getText(), (Race) raceComboBox.getSelectionModel().getSelectedItem());
        player.setAppearance(appearanceText);

        FXMLLoader loader = new FXMLLoader(GameTest.class.getResource("game.fxml"));
        Parent root = loader.load();
        GameController gameController = loader.getController();
        GameTest.setRoot(root);


        gameController.setGameInformation(world, player);
        gameController.startNewGame();
    }


    @FXML
    void characterChange(ActionEvent event) {
        appearanceText.setText(charComboBox.getSelectionModel().getSelectedItem().toString());

    }

    @FXML
    void colorChange(ActionEvent event) {
        ColorPicker colorPicker = (ColorPicker) event.getSource();
        appearanceText.setFill(colorPicker.getValue());
    }

}
