package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.example.world.Stone;
import org.example.world.World;

public class PrimaryController {

    @FXML
    private Text gameArea;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void initialize() {

        World world = new World();

        world.getRoom(0).setNonStackableEntity(new Stone(), 5, 5);
        Player eloy = new Player("Eloy", Race.HUMAN);
        eloy.spawnPlayer(world);

        gameArea.setText(eloy.getRoom().toString());

    }

}
