package de.cherry.battleship_helper;

import de.cherry.battleship.SetShipExeption;
import de.cherry.battleship.Ship;
import de.cherry.battleship.ShipMap;

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

    public boolean  onShip(int[] shot, ShipMap shipMap) {
        for (Ship ship : shipMap.battleship) {
            if(onShip(shot, ship)) return true;
        }
        for (Ship ship : shipMap.cruiser) {
            if(onShip(shot, ship)) return true;
        }
        for (Ship ship : shipMap.destroyer) {
            if(onShip(shot, ship)) return true;
        }
        for (Ship ship : shipMap.boomer) {
            if(onShip(shot, ship)) return true;
        }
        return false;
    }

    private boolean onShip(int[] shot, Ship ship) {
        boolean  vertical;

        int[] startPos = ship.getStartPos();
        int[] endPos = ship.getEndPos();

        if(startPos[0] == endPos[0]) {
            vertical = true;
        }
        else if (startPos[1] == endPos[1]){
            vertical = false;
        }
        else {
            throw new RuntimeException("Schiff krumm und nicht richtig überprüft");
        }
        if (vertical) {
            if(shot[1] <= endPos[1] || shot[1] >= startPos[1] ) {
                return true;
            }
        } else {
            if(shot[0] <= endPos[0] || shot[0] >= startPos[0] ) {
                return true;
            }
        }
        return false;

    }
}
