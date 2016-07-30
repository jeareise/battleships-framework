package de.cherry.Arena;

import de.cherry.battleship.Player;
import de.cherry.battleship.ShipMap;

import java.util.List;

public class Main
{

    public static void main(String[] args)
    {



        Player player1 = new Player() {
            @Override
            public void setzen(ShipMap shipMap) {

            }

            @Override
            public int[] schiessen(boolean sucessfullShoot, boolean shipDown) {
                return new int[0];
            }

            @Override
            public void endOfRound(boolean won, ShipMap shipMap, List<int[]> shoots) {

            }
        };
        Player player2 = new Player() {
            @Override
            public void setzen(ShipMap shipMap) {

            }

            @Override
            public int[] schiessen(boolean sucessfullShoot, boolean shipDown) {
                return new int[0];
            }

            @Override
            public void endOfRound(boolean won, ShipMap shipMap, List<int[]> shoots) {

            }
        };

        String[] st = {"","","",""};

        Arena arena = new Arena();
        arena.startGame(player1, player2);


    }
}
