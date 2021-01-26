package main.java.movement;

import main.java.Coordinates;

/**
 * Upon execution, moves the unit north by one tile.
 * <p>
 * As of now, this does not validate calls to {@code execute()} or {@code undo}, so care should be taken to only use
 * this with a legal destination.
 */
public class MoveNorth implements MovementCommand {

    private final Coordinates coordinates;

    public MoveNorth(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public void execute() {
        if (coordinates.diagonal <= 0) {
            //TODO handle this failure gracefully
        }
        coordinates.diagonal--;
    }

    @Override
    public void undo() {
        //Do we need to validate whether the coordinates would be valid? Theoretically, if the undo stack is managed properly, we shouldn't.
        coordinates.diagonal++;
    }
}
