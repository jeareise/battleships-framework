//Version 0.1
package de.cherry;

/**
 * Created by joshua on 25.07.16.
 */
public class Arena {

    private int PLAY_TIME = 1000;
    private Player schiffeversenkerBot1;
    private Player schiffeversenkerBot2;

    public Arena() {
        //asdf
    }

    public void startGame(Player schiffeversenkerBot1, Player schiffeversenkerBot2){
        ShipMap shipMapPlayer1 = new ShipMap();
        ShipMap shipMapPlayer2 = new ShipMap();

        Chronograph chronographPlayer1 = new Chronograph(PLAY_TIME);
        Chronograph chronographPlayer2 = new Chronograph(PLAY_TIME);

        chronographPlayer1.start();
        schiffeversenkerBot1.setzen(shipMapPlayer1);
        chronographPlayer1.stop();

        chronographPlayer2.start();
        schiffeversenkerBot2.setzen(shipMapPlayer2);
        chronographPlayer2.stop();

        if (!chronographPlayer1.inTime()){
            System.out.println("Player 2 hat gewonnen da Player 1 zulange gebraucht hat.");
        }

        if (!chronographPlayer2.inTime()){
            System.out.println("Player 1 hat gewonnen da Player 2 zulange gebraucht hat.");
        }

        Validator validator = new Validator();
        try {
            validator.validate(shipMapPlayer1);
        } catch (SetShipExeption setShipExeption) {
            setShipExeption.printStackTrace();
        }
        try {
            validator.validate(shipMapPlayer2);
        } catch (SetShipExeption setShipExeption) {
            setShipExeption.printStackTrace();
        }
    }

}
