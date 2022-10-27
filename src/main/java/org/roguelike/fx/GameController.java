package org.roguelike.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import org.roguelike.characters.Player;
import org.roguelike.world.Direction;
import org.roguelike.world.GamePrintStream;
import org.roguelike.world.World;


public class GameController {
    @FXML
    private TextFlow gameArea;

    @FXML
    private TextFlow gameTextFlow;

    @FXML
    private TextFlow mapTextFlow;

    @FXML
    private ScrollPane gameTextScrollPane;

    @FXML
    private ScrollPane mapTextScrollPane;

    @FXML
    private Label nameLabel;

    @FXML
    private Label levelLabel;

    @FXML
    private Label hpLabel;

    @FXML
    private Label raceLabel;


    private Text gameText;
    private Text mapText;

    private Player player;
    private World world;

    @FXML
    public void initialize() {
        gameText = new Text();
        mapText = new Text();

        gameTextFlow.getChildren().add(gameText);
        mapTextFlow.getChildren().add(mapText);
        mapTextFlow.setStyle("-fx-font-size: 20;");
        gameArea.setStyle("-fx-font-family: 'monospaced';-fx-font-size: 20; -fx-background-color: #707070");
        gameArea.setTextAlignment(TextAlignment.CENTER);

    }


    public void setGameInformation(World world, Player player){
        this.world = world;
        this.player = player;
    }

    public void startNewGame(){
        world.spawnPlayer(player);
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


    public void updateGame(){
        gameArea.getChildren().clear();
        for (var l : player.getRoom().getRoomList()){
            gameArea.getChildren().add(new Text("\n"));
            for (var t : l){
                TileText tileText = new TileText(t.getText(), t);
                gameArea.getChildren().add(tileText);
            }
        }

        gameText.setText(GamePrintStream.getGameText());
        gameTextScrollPane.setVvalue(gameTextScrollPane.getVmax());

        mapText.setText(world.toString());
        mapTextScrollPane.setVvalue(mapTextScrollPane.getVmax());

        nameLabel.setText(player.getName());
        levelLabel.setText(String.valueOf(player.getLevel()));
        hpLabel.setText(String.valueOf(player.getHp()));
        raceLabel.setText(player.getRace().name());

    }
}



