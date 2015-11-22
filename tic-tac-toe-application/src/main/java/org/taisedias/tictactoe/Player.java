package org.taisedias.tictactoe;

import lombok.Builder;

@Builder
public class Player {
    private char input;

    public char getInput() {
        return input;
    }
}
