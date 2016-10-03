package de.cherry.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 26.07.2016.
 */
public class Ship {
    private int defaultSize = 0;
    private int startPos[] = new int[2];
    private int endPos[] = new int[2];
    private int size;
    private List<int[]> shipBody = new ArrayList<int[]>();

    public int[] getStartPos() {
        return shipBody.get(0);
    }

    public int[] getEndPos() {
        return shipBody.get(shipBody.size() - 1);
    }

    public int getSize() {
        return size;
    }

    protected void setSize(int size) {
        this.size = size;
    }


    public List<int[]> getShipBody() {
        return shipBody;
    }

    public void setShipBody(List<int[]> shipBody) {
        this.shipBody = shipBody;
    }
}
