package org.example.world.ploy;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.example.world.Entity;
import org.example.world.ploy.EntityMover;

public class Albin extends Entity {

    private EntityMover entityMover;

    public void setEntityMover(EntityMover entityMover) {
        this.entityMover = entityMover;
    }

    public EntityMover getEntityMover() {
        return entityMover;
    }

    @Override
    public String toString() {
        return "A";
    }

    @Override
    public void printNonReachableMessage() {

    }

    @Override
    public Text getText() {
        Text text = new Text("A");
        text.setFill(Color.RED);
        return text;
    }
}
