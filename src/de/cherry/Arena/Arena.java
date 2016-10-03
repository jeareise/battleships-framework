//Version 0.1
package de.cherry.Arena;

import de.cherry.battleship.*;
import de.cherry.battleship_helper.Validator;

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
        ShipMap shipMapPlayer1 = new ShipMap(10);
        ShipMap shipMapPlayer2 = new ShipMap(10);

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

        ShootLogger shootLoggerPlayer1 = new ShootLogger();
        ShootLogger shootLoggerPlayer2 = new ShootLogger();

        shootLoggerPlayer1.init(shipMapPlayer2);
        shootLoggerPlayer2.init(shipMapPlayer1);

        boolean sucessfullShootLastRoundPlayer1 = false;
        boolean sucessfullShootLastRoundPlayer2 = false;
        boolean shipDownFromLastShootPlayer1 = false;
        boolean shipDownFromLastShootPlayer2 = false;


        boolean einerHatGewonnen = false;
        while (einerHatGewonnen == false) {
            chronographPlayer1.start();
            int[] shootPlayer1 = schiffeversenkerBot1.schiessen(sucessfullShootLastRoundPlayer1, shipDownFromLastShootPlayer1);
            chronographPlayer1.stop();

            ShootLog shootLogShootPlayer1 = shootLoggerPlayer1.shootedOn(shootPlayer1);


            sucessfullShootLastRoundPlayer1 = shootLogShootPlayer1.isOnSchip();
            shipDownFromLastShootPlayer1 = shootLogShootPlayer1.isShipDown();


            chronographPlayer2.start();
            int[] shootPlayer2 = schiffeversenkerBot1.schiessen(sucessfullShootLastRoundPlayer2, shipDownFromLastShootPlayer2);
            chronographPlayer2.stop();

            ShootLog shootLogShootPlayer2 = shootLoggerPlayer2.shootedOn(shootPlayer2);


            sucessfullShootLastRoundPlayer2 = shootLogShootPlayer2.isOnSchip();
            shipDownFromLastShootPlayer2 = shootLogShootPlayer2.isShipDown();


            if (!chronographPlayer1.inTime() && shootLoggerPlayer2.isNoShipLeft()) {
                System.out.println("Player 2 hat gewonnen");
                einerHatGewonnen = true;
            }

            if (!chronographPlayer2.inTime() && shootLoggerPlayer1isNoShipLeft()) {
                System.out.println("Player 1 hat gewonnen");
                einerHatGewonnen = true;
            }
        }
    }

}
