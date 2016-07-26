package de.cherry;

/**
 * Created by joshua on 25.07.16.
 */
public class Arena {

    private Player schiffeversenkerBot1;
    private Player schiffeversenkerBot2;

    public Arena() {
    }

    public void startGame(Player schiffeversenkerBot1, Player schiffeversenkerBot2){
        ShipMap shipMapPlayer1 = new ShipMap();
        ShipMap shipMapPlayer2 = new ShipMap();
        long time = System.currentTimeMillis();//todo replace whith joshi code
        schiffeversenkerBot1.setzen(shipMapPlayer1);
        long time2 = System.currentTimeMillis(); //todo replace whith joshi code

        schiffeversenkerBot2.setzen(shipMapPlayer2);


    }

}
