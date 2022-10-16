package org.example.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PrimaryController {

    @FXML
    TextField textField;
    @FXML
    private Button alertButton;

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
    void alert(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "alert yo");
        alert.setHeaderText("YOYOY");
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setId("okButton");
        var dialogPane = alert.getDialogPane();
        dialogPane.setId("dp");
        alert.showAndWait();
    }

    @FXML
    public void initialize() {

    }

}
