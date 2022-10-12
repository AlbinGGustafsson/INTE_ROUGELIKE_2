module org.example {
    requires javafx.controls;
    requires javafx.fxml;
//    requires org.testng;
//    requires org.junit.jupiter.api;

    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.world;
    opens org.example.world to javafx.fxml;
    exports org.example.world.ploy;
    opens org.example.world.ploy to javafx.fxml;
}
