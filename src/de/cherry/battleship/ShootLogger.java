package de.cherry.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 03.10.2016.
 */
public class ShootLogger {


    private List<ArenaShip> arenaShipList;

    public void init(ShipMap shipMap) {
        arenaShipList = new ArrayList<ArenaShip>();
        for (Battleship battleship : shipMap.battleship) {
            addShip(battleship.getShipBody());
        }
        for (Boomer boomer : shipMap.boomer) {
            addShip(boomer.getShipBody());
        }
        for (Destroyer destroyer : shipMap.destroyer) {
            addShip(destroyer.getShipBody());
        }

    }

    private void addShip(List<int[]> shipBody) {
        ArenaShip arenaShip = new ArenaShip();
        List<ShipTile> shipTiles = new ArrayList<ShipTile>();
        for (int[] ints : shipBody) {
            shipTiles.add(new ShipTile(ints[0], ints[1]));
        }
        arenaShip.setSchipTiles(shipTiles);

    }

    public ShootLog shootedOn(int[] shoot) {
        ShootLog shootLog = new ShootLog();
        shootLog.setPosition(shoot);
        ShipTile shootTile = new ShipTile(shoot[0], shoot[1]);
        for (ArenaShip arenaShip : arenaShipList) {
            if (!arenaShip.isDown()) {
                int size = arenaShip.getSchipTiles().size();
                shootLog.setGameOver(false);
                for (ShipTile shipTile : arenaShip.getSchipTiles()) {
                    if (shootTile.equals(shipTile)) {
                        size--;
                        shootLog.setOnSchip(true);
                    }
                }
                if (size == 0) {
                    shootLog.setShipDown(true);
                    arenaShip.setDown(true);
                }
            }


        }
        return shootLog;

    }
}
