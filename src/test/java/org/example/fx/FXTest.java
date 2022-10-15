package org.example.fx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

@ExtendWith(ApplicationExtension.class)
class FXTest {
    private static Scene scene;

    /**
     * Will be called with {@code @Before} semantics, i. e. before each test method.
     *
     * @param stage - Will be injected by the test runner.
     */
    @Start
    private void start(Stage stage) throws IOException {

//        Parent mainNode = FXMLLoader.load(App.class.getClassLoader().getResource("primary.fxml"));
//        stage.setScene(new Scene(mainNode));
//        stage.show();
//        stage.toFront();

        Parent mainNode = loadFXML("primary");
        scene = new Scene(mainNode);
        stage.setScene(scene);
        stage.show();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void test(FxRobot robot) throws IOException {

        //Button button = robot.lookup("#primaryButton").queryButton();
        Assertions.assertThat(robot.lookup("#primaryButton").queryButton()).hasText("Switch to Secondary View");
        //robot.clickOn("#primaryButton");
        setRoot("secondary");
        Assertions.assertThat(robot.lookup("#secondaryButton").queryButton()).hasText("Switch to Primary View");
        setRoot("primary");

    }
}