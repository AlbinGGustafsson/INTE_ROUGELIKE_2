package org.example.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import org.example.Player;
import org.example.Race;
import org.example.world.Direction;
import org.example.world.GamePrintStream;
import org.example.world.World;

public class GameController {
    @FXML
    private TextFlow gameArea;

    @FXML
    private TextFlow gameTextFlow;

    @FXML
    private ScrollPane gameTextScrollPane;

    private Text gameText;

    Player player;

    @FXML
    public void initialize() {

        gameText = new Text();
        gameTextFlow.getChildren().add(gameText);
        World world = new World();
        player = new Player("Albin", Race.HUMAN);
        world.spawnPlayer(player);
        gameArea.setStyle("-fx-font-family: 'monospaced';-fx-font-size: 20; -fx-background-color: #707070");
        gameArea.setTextAlignment(TextAlignment.CENTER);
        updateGame();
    }


    @FXML
    void moveDown(ActionEvent event) {
        player.move(Direction.DOWN);
        updateGame();
    }

    @FXML
    void moveDownLeft(ActionEvent event) {
        player.move(Direction.DOWN_LEFT);
        updateGame();
    }

    @FXML
    void moveDownRight(ActionEvent event) {
        player.move(Direction.DOWN_RIGHT);
        updateGame();
    }

    @FXML
    void moveLeft(ActionEvent event) {
        player.move(Direction.LEFT);
        updateGame();
    }

    @FXML
    void moveRight(ActionEvent event) {
        player.move(Direction.RIGHT);
        updateGame();
    }

    @FXML
    void moveUp(ActionEvent event) {
        player.move(Direction.UP);
        updateGame();
    }

    @FXML
    void moveUpLeft(ActionEvent event) {
        player.move(Direction.UP_LEFT);
        updateGame();
    }

    @FXML
    void moveUpRight(ActionEvent event) {
        player.move(Direction.UP_RIGHT);
        updateGame();
    }


    private void updateGame(){
        gameArea.getChildren().clear();
        for (var l : player.getRoom().getRoomList()){
            gameArea.getChildren().add(new Text("\n"));
            for (var t : l){
                gameArea.getChildren().add(t.getText());
            }
        }

        gameText.setText(GamePrintStream.getGameText());
        gameTextScrollPane.setVvalue(gameTextScrollPane.getVmax());

    }

}
