package org.roguelike.fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.roguelike.characters.Player;
import org.roguelike.characters.Race;
import org.roguelike.world.World;

import java.io.IOException;
import java.util.Arrays;

public class CharacterCreationController {


    private static final String CHARACTERS_TO_CHOOSE_FROM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @FXML
    private ColorPicker colorPicker;
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
        colorPicker.setValue(Color.BLACK);
        appearanceText.setFill(colorPicker.getValue());

    }
    @FXML
    void createNewGame(ActionEvent event) throws IOException {

        if (!nameInputIsCorrect()){
            return;
        }

        World world = new World();
        Player player = new Player(nameTextField.getText(), (Race) raceComboBox.getSelectionModel().getSelectedItem());
        player.setGuiAppearance(appearanceText);

        FXMLLoader loader = new FXMLLoader(GameTest.class.getResource("game.fxml"));
        Parent root = loader.load();
        GameController gameController = loader.getController();
        GameTest.setRoot(root);


        gameController.setGameInformation(world, player);
        gameController.startNewGame();
    }


    private boolean nameInputIsCorrect(){
        try{
            new Player(nameTextField.getText(), (Race) raceComboBox.getSelectionModel().getSelectedItem());
        }catch (IllegalArgumentException e){
            Alert nameInputAlert = new Alert(Alert.AlertType.ERROR);
            nameInputAlert.getDialogPane().setId("nameInputDialog");
            nameInputAlert.setHeaderText(e.getMessage());
            nameInputAlert.showAndWait();
            return false;
        }
        return true;
    }


    @FXML
    void characterChange(ActionEvent event) {
        appearanceText.setText(charComboBox.getSelectionModel().getSelectedItem().toString());

    }

    @FXML
    void colorChange(ActionEvent event) {
        appearanceText.setFill(colorPicker.getValue());
    }

}
