package org.taisedias.tictactoe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GameTest {
    private Player firstPlayer;
    private Player secondPlayer;
    private Game game;

    @Before
    public void setUp() {
        firstPlayer = Player.builder().input('o').build();
        secondPlayer = Player.builder().input('x').build();
        game = Game.builder().grid(new char[3][3]).build();
    }

    @Test
    public void firstPlayerShouldWinTheGame() {
        game.playTurn(firstPlayer, Position.builder().row(0).column(0).build());
        game.playTurn(secondPlayer, Position.builder().row(0).column(1).build());
        game.playTurn(firstPlayer, Position.builder().row(1).column(1).build());
        game.playTurn(secondPlayer, Position.builder().row(1).column(0).build());
        game.playTurn(firstPlayer, Position.builder().row(2).column(2).build());
        assertThat(game.isOver(), is(true));
    }

    @After
    public void tearDown() {
        firstPlayer = null;
        secondPlayer = null;
        game = null;
    }
}
