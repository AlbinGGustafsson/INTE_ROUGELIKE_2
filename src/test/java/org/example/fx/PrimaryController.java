package org.example.fx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PrimaryController {

    @FXML
    TextField textField;

    @FXML
    private void switchToSecondary() throws IOException {

        //AppTest.setRoot("secondary");

        FXMLLoader loader = new FXMLLoader(AppTest.class.getResource("secondary.fxml"));
        Parent root = loader.load();
        SecondaryController secondaryController = loader.getController();
        secondaryController.bruh(textField.getText());
        AppTest.setRoot(root);

    }

    @FXML
    public void initialize() {

    }

}
