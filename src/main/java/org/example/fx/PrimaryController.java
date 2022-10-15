package org.example.fx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        try {
            App.setRoot("secondary");
        }catch (RuntimeException e){

        }

    }

    @FXML
    public void initialize() {

    }

}
