package org.StrategyGame.movement;

import org.StrategyGame.Coordinates;

/**
 * Upon execution, moves the unit south by one tile.
 * <p>
 * As of now, this does not validate calls to {@code execute()} or {@code undo}, so care should be taken to only use
 * this with a legal destination.
 */
public class MoveSouth implements MovementCommand {

    private final Coordinates coordinates;

    public MoveSouth(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public void execute() {
        //TODO validate that the future coordinates are legal, and if not, fail gracefully
        coordinates.diagonal++;
    }

    @Override
    public void undo() {
        //Do we need to validate whether the coordinates would be valid? Theoretically, if the undo stack is managed properly, we shouldn't.
        coordinates.diagonal--;
    }
}
