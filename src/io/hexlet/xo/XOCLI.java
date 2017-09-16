package io.hexlet.xo;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.view.ConsoleView;

public class XOCLI {

    public static void main(final String[] args) {
        final Player[] players = new Player[2];
        final Player player1 = new Player("Gleb", Figure.X);
        final Player player2 = new Player("Slava", Figure.O);
        players[0] = player1;
        players[1] = player2;

        final Game<Figure> gameXO = new Game<>(players, new Field<>(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)){
            consoleView.show(gameXO);
        }

    }

}
