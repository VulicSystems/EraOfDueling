package main.java;

/**
 * Represents the coordinates of a particular game entity. The coordinates use diagonals, not rows, to ensure
 * consistency in the way that adjacent tiles are determined. The diagonals are drawn from the southwest to the
 * northeast. The first diagonal is the one in the top left of the board, so the top left tile is (0,0), the one below
 * it is (1,0), and the tile that borders both of those is (1,1).
 *
 * As of now, this does not enforce the usage of commands to alter the coordinates.
 */
public class Coordinates {
    public int diagonal = 0, column = 0;
}
