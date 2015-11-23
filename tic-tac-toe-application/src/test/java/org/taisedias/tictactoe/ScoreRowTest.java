package org.taisedias.tictactoe;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;

public class ScoreRowTest extends GameTest {
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
        assertThat(game.scoredDiagonal(), is(false));
        assertThat(game.scoredColumn(), is(false));
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
        assertThat(game.scoredDiagonal(), is(false));
        assertThat(game.scoredColumn(), is(false));
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
        assertThat(game.scoredDiagonal(), is(false));
        assertThat(game.scoredColumn(), is(false));
        assertThat(game.scoredRow(), is(true));
        assertThat(game.playerWins(), is(true));
        assertThat(game.isOver(), is(true));
    }
}
