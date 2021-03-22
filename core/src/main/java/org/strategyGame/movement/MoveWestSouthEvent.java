package org.strategyGame.movement;

import org.terasology.gestalt.entitysystem.event.Event;

/**
 * Upon execution, moves the unit to the southwest by one tile.
 * <p>
 * Note the convention of naming it "WestSouth", not "SouthWest" - since "East" and "West" aren't independent directions,
 * this naming convention should prevent errors caused by accidental usage of "South" instead of "SouthWest".
 */
public class MoveWestSouthEvent implements Event {
}
