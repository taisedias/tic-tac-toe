package org.taisedias.tictactoe;

import lombok.Builder;

@Builder
public class Game {
    private char[][] grid;

    public void playTurn(Player player, Position position) {
        grid[position.getRow()][position.getColumn()] = player.getInput();
    }

    public boolean isOver() {
        return true;
    }
}
