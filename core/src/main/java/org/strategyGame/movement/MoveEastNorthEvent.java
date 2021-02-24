package org.strategyGame.movement;

import org.terasology.gestalt.entitysystem.event.Event;

/**
 * Upon execution, moves the entity to the northeast by one tile.
 * <p>
 * Note the convention of naming it "EastNorth", not "NorthEast" - since "East" and "West" aren't independent directions,
 * this naming convention should prevent errors caused by accidental usage of "North" instead of "NorthEast".
 */
public class MoveEastNorthEvent implements Event {
}
