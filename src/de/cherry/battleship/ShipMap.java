package de.cherry.battleship;

/**
 * Created by Max on 26.07.2016.
 */
public class ShipMap {
    public Battleship[] battleship;
    public Cruiser[] cruiser;
    public Destroyer[] destroyer;
    public Boomer[] boomer;
    private int width;
    private int height;

    public ShipMap(int size) {
        battleship = new Battleship[1];
        cruiser = new Cruiser[2];
        destroyer = new Destroyer[3];
        boomer = new Boomer[4];
        height = size;
        width = size;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
