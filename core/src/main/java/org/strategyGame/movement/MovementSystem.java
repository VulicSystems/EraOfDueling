package org.strategyGame.movement;

import org.strategyGame.ecsStructure.GameSystem;
import org.terasology.gestalt.entitysystem.entity.EntityRef;
import org.terasology.gestalt.entitysystem.event.EventResult;
import org.terasology.gestalt.entitysystem.event.ReceiveEvent;

/**
 * This system handles movement of entities with a {@link BoardPosition} component.
 *
 * TODO validate the movement to ensure that it does not go out of bounds
 */
public class MovementSystem implements GameSystem {

    @ReceiveEvent(components = {BoardPosition.class})
    public EventResult moveEastNorth(MoveEastNorthEvent moveEastNorthEvent, EntityRef entity) {
        BoardPosition boardPosition = entity.getComponent(BoardPosition.class).get();
        boardPosition.column++;
        entity.setComponent(boardPosition);
        return EventResult.CONTINUE;
    }

    @ReceiveEvent(components = {BoardPosition.class})
    public EventResult moveEastSouth(MoveEastSouthEvent moveEastSouthEvent, EntityRef entity) {
        BoardPosition boardPosition = entity.getComponent(BoardPosition.class).get();
        boardPosition.diagonal++;
        boardPosition.column++;
        entity.setComponent(boardPosition);
        return EventResult.CONTINUE;
    }

    @ReceiveEvent(components = {BoardPosition.class})
    public EventResult moveSouth(MoveSouthEvent moveSouthEvent, EntityRef entity) {
        BoardPosition boardPosition = entity.getComponent(BoardPosition.class).get();
        boardPosition.diagonal++;
        entity.setComponent(boardPosition);
        return EventResult.CONTINUE;
    }

    @ReceiveEvent(components = {BoardPosition.class})
    public EventResult moveWestSouth(MoveWestSouthEvent moveWestSouthEvent, EntityRef entity) {
        BoardPosition boardPosition = entity.getComponent(BoardPosition.class).get();
        boardPosition.column--;
        entity.setComponent(boardPosition);
        return EventResult.CONTINUE;
    }

    @ReceiveEvent(components = {BoardPosition.class})
    public EventResult moveWestNorth(MoveWestNorthEvent moveWestNorthEvent, EntityRef entity) {
        BoardPosition boardPosition = entity.getComponent(BoardPosition.class).get();
        boardPosition.diagonal--;
        boardPosition.column--;
        entity.setComponent(boardPosition);
        return EventResult.CONTINUE;
    }

    @ReceiveEvent(components = {BoardPosition.class})
    public EventResult moveNorth(MoveNorthEvent moveNorthEvent, EntityRef entity) {
        BoardPosition boardPosition = entity.getComponent(BoardPosition.class).get();
        boardPosition.diagonal--;
        entity.setComponent(boardPosition);
        return EventResult.CONTINUE;
    }
}
