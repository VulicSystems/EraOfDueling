package org.strategyGame.movement;

import org.strategyGame.ecsStructure.GameSystem;
import org.terasology.gestalt.entitysystem.entity.EntityRef;
import org.terasology.gestalt.entitysystem.event.EventResult;
import org.terasology.gestalt.entitysystem.event.ReceiveEvent;

/**
 * This system handles movement of entities with a {@link Coordinates} component.
 *
 * TODO validate the movement to ensure that it does not go out of bounds
 */
public class MovementSystem implements GameSystem {

    @ReceiveEvent(components = {Coordinates.class})
    public EventResult moveEastNorth(MoveEastNorthEvent moveEastNorthEvent, EntityRef entity) {
        Coordinates coordinates = entity.getComponent(Coordinates.class).get();
        coordinates.column++;
        entity.setComponent(coordinates);
        return EventResult.CONTINUE;
    }

    @ReceiveEvent(components = {Coordinates.class})
    public EventResult moveEastSouth(MoveEastSouthEvent moveEastSouthEvent, EntityRef entity) {
        Coordinates coordinates = entity.getComponent(Coordinates.class).get();
        coordinates.diagonal++;
        coordinates.column++;
        entity.setComponent(coordinates);
        return EventResult.CONTINUE;
    }

    @ReceiveEvent(components = {Coordinates.class})
    public EventResult moveSouth(MoveSouthEvent moveSouthEvent, EntityRef entity) {
        Coordinates coordinates = entity.getComponent(Coordinates.class).get();
        coordinates.diagonal++;
        entity.setComponent(coordinates);
        return EventResult.CONTINUE;
    }

    @ReceiveEvent(components = {Coordinates.class})
    public EventResult moveWestSouth(MoveWestSouthEvent moveWestSouthEvent, EntityRef entity) {
        Coordinates coordinates = entity.getComponent(Coordinates.class).get();
        coordinates.column--;
        entity.setComponent(coordinates);
        return EventResult.CONTINUE;
    }

    @ReceiveEvent(components = {Coordinates.class})
    public EventResult moveWestNorth(MoveWestNorthEvent moveWestNorthEvent, EntityRef entity) {
        Coordinates coordinates = entity.getComponent(Coordinates.class).get();
        coordinates.diagonal--;
        coordinates.column--;
        entity.setComponent(coordinates);
        return EventResult.CONTINUE;
    }

    @ReceiveEvent(components = {Coordinates.class})
    public EventResult moveNorth(MoveNorthEvent moveNorthEvent, EntityRef entity) {
        Coordinates coordinates = entity.getComponent(Coordinates.class).get();
        coordinates.diagonal--;
        entity.setComponent(coordinates);
        return EventResult.CONTINUE;
    }
}
