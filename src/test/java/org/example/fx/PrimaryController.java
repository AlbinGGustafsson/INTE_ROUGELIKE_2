package org.example.fx;

import javafx.fxml.FXML;

import java.io.IOException;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
            FXTest.setRoot("secondary");
    }

    @FXML
    public void initialize() {

    }

}
