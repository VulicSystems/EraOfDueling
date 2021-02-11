package org.StrategyGame.movement;

import org.terasology.gestalt.entitysystem.event.Event;

/**
 * Upon execution, moves the unit to the southeast by one tile.
 * <p>
 * Note the convention of naming it "EastSouth", not "SouthEast" - since "East" and "West" aren't independent directions,
 * this naming convention should prevent errors caused by accidental usage of "South" instead of "SouthEast".
 */
public class MoveEastSouthEvent implements Event {
}
