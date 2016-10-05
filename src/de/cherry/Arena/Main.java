package de.cherry.Arena;

import de.cherry.battleship.Player;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Player player1 = new PlayerLoader().load(new File("F:\\Programmieren\\Projekts\\Idea\\pluginExample\\out\\artifacts\\pluginExample_jar\\"));
        Player player2 = new PlayerLoader().load(new File("F:\\Programmieren\\Projekts\\Idea\\pluginExample\\out\\artifacts\\pluginExample_jar\\"));

        Arena arena = new Arena();
        arena.startGame(player1, player2);


    }
}
