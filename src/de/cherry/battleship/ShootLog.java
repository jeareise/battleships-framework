package de.cherry.battleship;

/**
 * Created by Max on 03.10.2016.
 */
public class ShootLog {
    private int[] position;
    private boolean onSchip;
    private boolean shipDown;


    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public boolean isOnSchip() {
        return onSchip;
    }

    public void setOnSchip(boolean onSchip) {
        this.onSchip = onSchip;
    }

    public boolean isShipDown() {
        return shipDown;
    }

    public void setShipDown(boolean shipDown) {
        this.shipDown = shipDown;
    }
}
