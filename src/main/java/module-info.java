module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.management;

    opens org.roguelike to javafx.fxml;
    exports org.roguelike;
    exports org.roguelike.world;
    opens org.roguelike.world to javafx.fxml;
    exports org.roguelike.fx;
    opens org.roguelike.fx to javafx.fxml;
    exports org.roguelike.characters;
    opens org.roguelike.characters to javafx.fxml;
    exports org.roguelike.monster;
    opens org.roguelike.monster to javafx.fxml;
    exports org.roguelike.gear;
    opens org.roguelike.gear to javafx.fxml;
    exports org.roguelike.combat;
    opens org.roguelike.combat to javafx.fxml;
    exports org.roguelike.inventory;
    opens org.roguelike.inventory to javafx.fxml;
    exports org.roguelike.quest;
    opens org.roguelike.quest to javafx.fxml;
}
