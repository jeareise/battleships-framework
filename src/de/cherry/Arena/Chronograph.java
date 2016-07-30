package de.cherry.Arena;

public class Chronograph {
    private long millis;
    private long pasedTime = 0;
    private long maxTime;

    public Chronograph(long maxTime) {
        this.maxTime = maxTime;
    }

    public void start() {
        millis = System.currentTimeMillis();
    }

    public long stop() {
        long endmillis = System.currentTimeMillis();
        pasedTime += endmillis - 1 - millis;
        return pasedTime;
    }

    public boolean inTime(){
        return pasedTime <= maxTime;
    }
}