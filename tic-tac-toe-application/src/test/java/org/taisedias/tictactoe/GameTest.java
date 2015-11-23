package org.taisedias.tictactoe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;

public class GameTest {
    private Player firstPlayer;
    private Player secondPlayer;
    private Game game;
    private char o = 'o';
    private char x = 'x';

    @Before
    public void setUp() {
        firstPlayer = Player.builder().input(o).build();
        secondPlayer = Player.builder().input(x).build();
        game = Game.builder().grid(new char[3][3]).build();
    }

    @Test
    public void firstPlayerShouldScoreFirstRow() {
        game.playTurn(firstPlayer, Position.builder().row(0).column(0).build());
        game.playTurn(secondPlayer, Position.builder().row(1).column(1).build());
        game.playTurn(firstPlayer, Position.builder().row(0).column(1).build());
        game.playTurn(secondPlayer, Position.builder().row(1).column(0).build());
        game.playTurn(firstPlayer, Position.builder().row(0).column(2).build());
        assertArrayEquals(new char[][]{{o, o, o},
                                       {x, x, 0},
                                       {0, 0, 0}}, game.getGrid());
        assertThat(game.scoredRow(), is(true));
        assertThat(game.playerWins(), is(true));
        assertThat(game.isOver(), is(true));
    }

    @Test
    public void secondPlayerShouldScoreSecondRow() {
        game.playTurn(firstPlayer, Position.builder().row(0).column(0).build());
        game.playTurn(secondPlayer, Position.builder().row(1).column(1).build());
        game.playTurn(firstPlayer, Position.builder().row(2).column(2).build());
        game.playTurn(secondPlayer, Position.builder().row(1).column(0).build());
        game.playTurn(firstPlayer, Position.builder().row(0).column(2).build());
        game.playTurn(secondPlayer, Position.builder().row(1).column(2).build());
        assertArrayEquals(new char[][]{{o, 0, o},
                                       {x, x, x},
                                       {0, 0, o}}, game.getGrid());
        assertThat(game.scoredRow(), is(true));
        assertThat(game.playerWins(), is(true));
        assertThat(game.isOver(), is(true));
    }

    @Test
    public void firstPlayerShouldScoreThirdRow() {
        game.playTurn(firstPlayer, Position.builder().row(2).column(0).build());
        game.playTurn(secondPlayer, Position.builder().row(1).column(1).build());
        game.playTurn(firstPlayer, Position.builder().row(2).column(1).build());
        game.playTurn(secondPlayer, Position.builder().row(1).column(0).build());
        game.playTurn(firstPlayer, Position.builder().row(2).column(2).build());
        assertArrayEquals(new char[][]{{0, 0, 0},
                                       {x, x, 0},
                                       {o, o, o}}, game.getGrid());
        assertThat(game.scoredRow(), is(true));
        assertThat(game.playerWins(), is(true));
        assertThat(game.isOver(), is(true));
    }

    @Test
    public void inputShouldBeValid() {
        assertThat(game.isValid(o), is(true));
        assertThat(game.isValid(x), is(true));
    }

    @Test
    public void inputShouldBeInvalid() {
        assertThat(game.isValid(game.getGrid()[2][2]), is(false));
    }

    @After
    public void tearDown() {
        firstPlayer = null;
        secondPlayer = null;
        game = null;
    }
}
