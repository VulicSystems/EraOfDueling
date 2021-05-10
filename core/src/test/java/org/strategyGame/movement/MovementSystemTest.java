package org.strategyGame.movement;

import junit.framework.TestCase;
import org.junit.Before;
import org.strategyGame.ServiceLocatorMap;
import org.strategyGame.ecsStructure.ECSManager;
import org.terasology.gestalt.entitysystem.component.management.ComponentManager;
import org.terasology.gestalt.entitysystem.entity.EntityRef;

public class MovementSystemTest extends TestCase {

    private ECSManager ecsManager;
    private BoardPosition boardPosition;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        ecsManager = new ECSManager(new ComponentManager(), new ServiceLocatorMap());
        boardPosition = new BoardPosition();
        boardPosition.diagonal = 3;
        boardPosition.column = 3;
    }

    public void testMoveEastNorth() {
        EntityRef entity = ecsManager.createEntity(boardPosition);

        ecsManager.sendEventBlocking(new MoveEastNorthEvent(), entity);
        BoardPosition newBoardPosition = entity.getComponent(BoardPosition.class).get();

        assertEquals(3, newBoardPosition.diagonal);
        assertEquals(4, newBoardPosition.column);
    }

    public void testMoveEastSouth() {
        EntityRef entity = ecsManager.createEntity(boardPosition);

        ecsManager.sendEventBlocking(new MoveEastSouthEvent(), entity);
        BoardPosition newBoardPosition = entity.getComponent(BoardPosition.class).get();

        assertEquals(4, newBoardPosition.diagonal);
        assertEquals(4, newBoardPosition.column);
    }

    public void testMoveSouth() {
        EntityRef entity = ecsManager.createEntity(boardPosition);

        ecsManager.sendEventBlocking(new MoveSouthEvent(), entity);
        BoardPosition newBoardPosition = entity.getComponent(BoardPosition.class).get();

        assertEquals(4, newBoardPosition.diagonal);
        assertEquals(3, newBoardPosition.column);
    }

    public void testMoveWestSouth() {
        EntityRef entity = ecsManager.createEntity(boardPosition);

        ecsManager.sendEventBlocking(new MoveWestSouthEvent(), entity);
        BoardPosition newBoardPosition = entity.getComponent(BoardPosition.class).get();

        assertEquals(3, newBoardPosition.diagonal);
        assertEquals(2, newBoardPosition.column);
    }

    public void testMoveWestNorth() {
        EntityRef entity = ecsManager.createEntity(boardPosition);

        ecsManager.sendEventBlocking(new MoveWestNorthEvent(), entity);
        BoardPosition newBoardPosition = entity.getComponent(BoardPosition.class).get();

        assertEquals(2, newBoardPosition.diagonal);
        assertEquals(2, newBoardPosition.column);
    }

    public void testMoveNorth() {
        EntityRef entity = ecsManager.createEntity(boardPosition);

        ecsManager.sendEventBlocking(new MoveNorthEvent(), entity);
        BoardPosition newBoardPosition = entity.getComponent(BoardPosition.class).get();

        assertEquals(2, newBoardPosition.diagonal);
        assertEquals(3, newBoardPosition.column);
    }
}