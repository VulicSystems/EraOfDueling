package org.StrategyGame.movement;

import org.terasology.gestalt.entitysystem.event.Event;

/**
 * Upon execution, moves the unit to the northwest by one tile.
 * <p>
 * Note the convention of naming it "WestNorth", not "NorthWest" - since "East" and "West" aren't independent directions,
 * this naming convention should prevent errors caused by accidental usage of "North" instead of "NorthWest".
 */
public class MoveWestNorthEvent implements Event {
}
