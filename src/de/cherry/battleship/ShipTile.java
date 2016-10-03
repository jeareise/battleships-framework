package de.cherry.battleship;

/**
 * Created by Max on 03.10.2016.
 */
public class ShipTile {
    private int posX;
    private int posY;
    private boolean hitten = false;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isHitten() {
        return hitten;
    }

    public void setHitten(boolean hitten) {
        this.hitten = hitten;
    }

    @Override
    public boolean equals(Object obj) {
        ShipTile zuVergleichen = (ShipTile) obj;
        return zuVergleichen.getPosX() == this.getPosX() && zuVergleichen.getPosY() == this.getPosY();
    }
}
