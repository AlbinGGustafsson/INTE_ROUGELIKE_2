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

    }

}
