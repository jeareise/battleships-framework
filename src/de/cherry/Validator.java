package de.cherry;

/**
 * Created by Max on 26.07.2016.
 */
public class Validator {
    public boolean validate(ShipMap shipMap) throws SetShipExeption {
        boolean passed = true;
        int height = shipMap.getHeight();
        int width = shipMap.getWidth();
        for (Ship ship : shipMap.battleship) {
            passed = validate(ship, height, width);
        }
        for (Ship ship : shipMap.cruiser) {
            passed = validate(ship, height, width);
        }
        for (Ship ship : shipMap.destroyer) {
            passed = validate(ship, height, width);
        }
        for (Ship ship : shipMap.boomer) {
            passed = validate(ship, height, width);
        }
        return passed;
    }

    private boolean pointFromArea(int[] point, int i, int[] mapSize) {
        return point[i] > mapSize[i] && point[i] < 0;
    }

    private boolean shipValid(int shipSize, int[] startPos, int[] endPos) throws SetShipExeption {
        int temp0 = startPos[0] - endPos[0];
        int temp1 = startPos[1] - endPos[1];
        // check for straight ship
        if(temp0 != 0 && temp1 != 0) {
            throw new SetShipExeption("das Schiff ist neicht gerade");
        }

        // check for valid size of the ship
        // vertical
        if(temp0 != 0) {
            temp0 = temp0 + shipSize -1;
            if(temp0 != 0){
                throw new SetShipExeption("schiff größe ist falsch");
            }
        }
        // horizontal
        else{
            temp1 = temp1 + shipSize -1;
            if(temp1 != 0) {
                throw new SetShipExeption("schiff größe ist falsch");
            }
        }
        return true;
    }

    public boolean validate(Ship ship, int mapHeight, int mapWidth) throws SetShipExeption {
        int shipSize = ship.getSize();
        boolean passed = true;
        int startPos[], endPos[];
        startPos = ship.getStartPos();
        endPos = ship.getEndPos();
        int[] mapSize = {mapHeight, mapWidth};

        for (int i = 0; i < startPos.length; i++) {
            if (pointFromArea(startPos, i, mapSize) && pointFromArea(startPos, i, mapSize))
                throw new SetShipExeption("");

        }
        //todo schiffe dürfen sich nicht überlappen
        shipValid(ship.getSize(), startPos, endPos);
        return passed;
    }
}
