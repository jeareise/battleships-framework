package de.cherry.battleship;

/**
 * Created by Max on 26.07.2016.
 */
public class Ship {
    private int defaultSize = 0;
    private int startPos[] = new int[2];
    private int endPos[] = new int[2];

    public int[] getStartPos() {
        return startPos;
    }

    public void setStartPos(int[] startPos) {
        this.startPos = startPos;
    }

    public int[] getEndPos() {
        return endPos;
    }

    public void setEndPos(int[] endPos) {
        this.endPos = endPos;
    }

    public int getSize() {
        return size;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    private int size;

}
