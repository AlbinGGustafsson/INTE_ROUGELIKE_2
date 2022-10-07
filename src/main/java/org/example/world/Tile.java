import java.util.ArrayList;

public class Tile {
    private int x;
    private int y;
    private ArrayList<Entity> entities = new ArrayList<>();
    private Terrain terrainType;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setTerrainType(Terrain terrainType) {
        this.terrainType = terrainType;
    }

    public Terrain getTerrainType() {
        return terrainType;
    }

    public void addTileEntity(Entity e){
        entities.add(e);
    }

    public void removeEntity(Entity e){
        entities.remove(e);
    }

}
