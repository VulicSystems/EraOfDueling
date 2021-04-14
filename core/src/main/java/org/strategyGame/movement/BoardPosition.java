package org.strategyGame.movement;

import org.terasology.gestalt.entitysystem.component.Component;

/**
 * Represents the board position of a particular game entity. The position coordinates use diagonals, not rows, to ensure
 * consistency in the way that adjacent tiles are determined. The diagonals are drawn from the southwest to the
 * northeast. The first diagonal is the one in the top left of the board, so the top left tile is (0,0), the one below
 * it is (1,0), and the tile that borders both of those is (1,1).
 */
public class BoardPosition implements Component<BoardPosition> {
    public int diagonal = 0, column = 0;

    @Override
    public void copy(BoardPosition other) {
        this.diagonal = other.diagonal;
        this.column = other.column;
    }
}
