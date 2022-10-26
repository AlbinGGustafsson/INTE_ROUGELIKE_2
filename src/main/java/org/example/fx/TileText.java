package org.example.fx;

import javafx.scene.text.Text;
import org.example.world.Tile;

public class TileText extends Text {
    private final Tile tile;

    public TileText(Text text,Tile tile) {
        setText(text.getText());
        setStyle(text.getStyle());
        setFill(text.getFill());
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }
}
