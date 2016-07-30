package de.cherry.battleship;

import java.util.List;

/**
 * Created by joshua on 25.07.16.
 */
public interface Player {

    public void setzen(ShipMap shipMap);

    public int[] schiessen(boolean sucessfullShoot, boolean shipDown);

    public void endOfRound(boolean won, ShipMap shipMap, List<int[]> shoots);

}
