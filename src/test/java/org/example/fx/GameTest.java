package org.example.fx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;
@ExtendWith(ApplicationExtension.class)
public class GameTest {

    private static Scene scene;
    private static Stage stage;


    @Start
    private void start(Stage stage) throws IOException {
        GameTest.stage = stage;
        scene = new Scene(loadFXML("characterCreation"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(Parent p){
        scene.setRoot(p);
        stage.sizeToScene();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameTest.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    @Test
    void test(FxRobot robot) {
        robot.clickOn("#newGameButton");
    }

}
