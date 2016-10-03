package de.cherry.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 03.10.2016.
 */
public class ArenaShip {

    private List<ShipTile> schipTiles = new ArrayList<ShipTile>();

    private boolean Down = false;

    public List<ShipTile> getSchipTiles() {
        return schipTiles;
    }

    public void setSchipTiles(List<ShipTile> schipTiles) {
        this.schipTiles = schipTiles;
    }

    public boolean isDown() {
        return Down;
    }

    public void setDown(boolean down) {
        Down = down;
    }
}
