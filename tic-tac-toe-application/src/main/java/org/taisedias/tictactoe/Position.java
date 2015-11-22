package org.taisedias.tictactoe;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Position {
    private int column;
    private int row;

}
