package org.taisedias.tictactoe;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;

public class ScoreDiagonalTest extends GameTest {

    @Test
    public void firstPlayerShouldScoreFirstDiagonal() {
        game.playTurn(firstPlayer, Position.builder().row(0).column(0).build());
        game.playTurn(secondPlayer, Position.builder().row(2).column(1).build());
        game.playTurn(firstPlayer, Position.builder().row(1).column(1).build());
        game.playTurn(secondPlayer, Position.builder().row(0).column(1).build());
        game.playTurn(firstPlayer, Position.builder().row(2).column(2).build());
        assertArrayEquals(new char[][]{{o, x, 0},
                                       {0, o, 0},
                                       {0, x, o}}, game.getGrid());
        assertThat(game.scoredRow(), is(false));
        assertThat(game.scoredColumn(), is(false));
        assertThat(game.scoredDiagonal(), is(true));
        assertThat(game.playerWins(), is(true));
        assertThat(game.isOver(), is(true));
    }

    @Test
    public void secondPlayerShouldScoreSecondDiagonal() {
        game.playTurn(firstPlayer, Position.builder().row(0).column(0).build());
        game.playTurn(secondPlayer, Position.builder().row(0).column(2).build());
        game.playTurn(firstPlayer, Position.builder().row(2).column(2).build());
        game.playTurn(secondPlayer, Position.builder().row(1).column(1).build());
        game.playTurn(firstPlayer, Position.builder().row(0).column(1).build());
        game.playTurn(secondPlayer, Position.builder().row(2).column(0).build());
        assertArrayEquals(new char[][]{{o, o, x},
                                       {0, x, 0},
                                       {x, 0, o}}, game.getGrid());
        assertThat(game.scoredRow(), is(false));
        assertThat(game.scoredColumn(), is(false));
        assertThat(game.scoredDiagonal(), is(true));
        assertThat(game.playerWins(), is(true));
        assertThat(game.isOver(), is(true));
    }

}
