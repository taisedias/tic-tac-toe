package org.taisedias.tictactoe;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Game {
    private char[][] grid = new char[3][3];

    public void playTurn(Player player, Position position) {
        grid[position.getRow()][position.getColumn()] = player.getInput();
    }

    public boolean isOver() {
        return playerWins();
    }

    public boolean playerWins() {
        return scoredRow() || scoredColumn() || scoredDiagonal();
    }

    public boolean scoredColumn() {
        boolean wins;
        for (int column = 0; column < grid.length; column++) {
            char input = grid[0][column];
            if (!isValid(input)) {
                continue;
            }
            wins = true;
            for (int row = 1; row < grid.length; row++) {
                wins = wins && (input == grid[row][column]);
            }
            if (wins) {
                return wins;
            }
        }
        return false;
    }

    public boolean scoredDiagonal() {
        return false;
    }

    public boolean scoredRow() {
        boolean wins;

        for (int row = 0; row < grid.length; row++) {
            char input = grid[row][0];
            if (!isValid(input)) {
                continue;
            }
            wins = true;
            for (int column = 1; column < grid[row].length; column++) {
                wins = wins && (input == grid[row][column]);
            }
            if (wins) {
                return wins;
            }
        }
        return false;
    }

    public boolean isValid(char input) {
        return (input == 'o') || (input == 'x');
    }
}
