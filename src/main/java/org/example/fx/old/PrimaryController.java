//package org.example.fx;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.text.Text;
//import javafx.scene.text.TextAlignment;
//import javafx.scene.text.TextFlow;
//import org.example.Player;
//import org.example.Race;
//import org.example.world.PrintFormatConstants;
//import org.example.world.World;
//
//import java.io.IOException;
//
//public class PrimaryController {
//    @FXML
//    TextField textField;
//    @FXML
//    private void switchToSecondary() throws IOException {
//
//        //App.setRoot("secondary");
//
//        FXMLLoader loader = new FXMLLoader(App.class.getResource("secondary.fxml"));
//        Parent root = loader.load();
//        SecondaryController secondaryController = loader.getController();
//        secondaryController.bruh(textField.getText());
//        App.setRoot(root);
//    }
//
//    @FXML
//    void alert(ActionEvent event) {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION, "alert yo");
//        alert.setHeaderText("YOYOY");
//        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
//        okButton.setId("okButton");
//        var dialogPane = alert.getDialogPane();
//        dialogPane.setId("dp");
//        alert.showAndWait();
//    }
//
//}