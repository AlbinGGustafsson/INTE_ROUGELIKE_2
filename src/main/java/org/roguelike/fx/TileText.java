package org.roguelike.fx;

import javafx.scene.text.Text;
import org.roguelike.world.Tile;

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
