package de.cherry;

public class Main
{

    public static void main(String[] args)
    {



        Player player1 = new Player() {
            @Override
            public void setzen(ShipMap shipMap) {

            }

            @Override
            public String[] schiessen() {
                return new String[0];
            }
        };
        Player player2 = new Player() {
            @Override
            public void setzen(ShipMap shipMap) {

            }

            @Override
            public String[] schiessen() {
                return new String[0];
            }
        };

        String[] st = {"","","",""};

        Arena arena = new Arena();
        arena.startGame(player1, player2);


    }
}
