package main.java.movement;

import main.java.Coordinates;

/**
 * Upon execution, moves the unit to the southwest by one tile.
 * <p>
 * Note the convention of naming it "WestSouth", not "SouthWest" - since "East" and "West" aren't independent directions,
 * this naming convention should prevent errors caused by accidental usage of "South" instead of "SouthWest".
 * <p>
 * As of now, this does not validate calls to {@code execute()} or {@code undo()}, so care should be taken to only use
 * this with a legal destination.
 */
public class MoveWestSouth implements MovementCommand {

    private final Coordinates coordinates;

    public MoveWestSouth(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public void execute() {
        //TODO validate that the future coordinates are legal, and if not, fail gracefully
        coordinates.column--;
    }

    @Override
    public void undo() {
        //Do we need to validate whether the coordinates would be valid? Theoretically, if the undo stack is managed properly, we shouldn't.
        coordinates.column++;
    }
}
