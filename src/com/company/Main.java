package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Fred"));
        players.add(new Player("George"));

        Game game = new Game(players);

        game.runGame();
    }
}
