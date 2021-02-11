package org.StrategyGame;

import org.terasology.gestalt.entitysystem.component.Component;

/**
 * Represents the coordinates of a particular game entity. The coordinates use diagonals, not rows, to ensure
 * consistency in the way that adjacent tiles are determined. The diagonals are drawn from the southwest to the
 * northeast. The first diagonal is the one in the top left of the board, so the top left tile is (0,0), the one below
 * it is (1,0), and the tile that borders both of those is (1,1).
 */
public class Coordinates implements Component<Coordinates> {
    public int diagonal = 0, column = 0;

    @Override
    public void copy(Coordinates other) {
        this.diagonal = other.diagonal;
        this.column = other.column;
    }
}
