package de.cherry;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main
{

    public static void main(String[] args)
    {



        Player player1 = new Player1();
        Player player2 = new Player2();

        String[] st = {"","","",""};

        Arena arena = new Arena();
        arena.startGame(player1, player2);


    }
}
