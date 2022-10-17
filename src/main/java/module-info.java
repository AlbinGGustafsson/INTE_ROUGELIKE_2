module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.management;
//    requires org.testng;
//    requires org.junit.jupiter.api;

    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.world;
    opens org.example.world to javafx.fxml;
    exports org.example.world.ploy;
    opens org.example.world.ploy to javafx.fxml;
    exports org.example.fx;
    opens org.example.fx to javafx.fxml;
    exports org.example.characters;
    opens org.example.characters to javafx.fxml;
    exports org.example.Monster;
    opens org.example.Monster to javafx.fxml;
}
