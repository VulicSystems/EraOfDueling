package org.strategyGame.movement;

import junit.framework.TestCase;
import org.junit.Before;
import org.strategyGame.ecsStructure.ECSManager;
import org.terasology.gestalt.entitysystem.component.management.ComponentManager;
import org.terasology.gestalt.entitysystem.entity.EntityRef;

public class MovementSystemTest extends TestCase {

    private ECSManager ecsManager;
    private Coordinates coordinates;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        ecsManager = new ECSManager(new ComponentManager());
        coordinates = new Coordinates();
        coordinates.diagonal = 3;
        coordinates.column = 3;
    }

    public void testMoveEastNorth() {
        EntityRef entity = ecsManager.createEntity(coordinates);

        ecsManager.sendEventBlocking(new MoveEastNorthEvent(), entity);
        Coordinates newCoordinates = entity.getComponent(Coordinates.class).get();

        assertEquals(3, newCoordinates.diagonal);
        assertEquals(4, newCoordinates.column);
    }

    public void testMoveEastSouth() {
        EntityRef entity = ecsManager.createEntity(coordinates);

        ecsManager.sendEventBlocking(new MoveEastSouthEvent(), entity);
        Coordinates newCoordinates = entity.getComponent(Coordinates.class).get();

        assertEquals(4, newCoordinates.diagonal);
        assertEquals(4, newCoordinates.column);
    }

    public void testMoveSouth() {
        EntityRef entity = ecsManager.createEntity(coordinates);

        ecsManager.sendEventBlocking(new MoveSouthEvent(), entity);
        Coordinates newCoordinates = entity.getComponent(Coordinates.class).get();

        assertEquals(4, newCoordinates.diagonal);
        assertEquals(3, newCoordinates.column);
    }

    public void testMoveWestSouth() {
        EntityRef entity = ecsManager.createEntity(coordinates);

        ecsManager.sendEventBlocking(new MoveWestSouthEvent(), entity);
        Coordinates newCoordinates = entity.getComponent(Coordinates.class).get();

        assertEquals(3, newCoordinates.diagonal);
        assertEquals(2, newCoordinates.column);
    }

    public void testMoveWestNorth() {
        EntityRef entity = ecsManager.createEntity(coordinates);

        ecsManager.sendEventBlocking(new MoveWestNorthEvent(), entity);
        Coordinates newCoordinates = entity.getComponent(Coordinates.class).get();

        assertEquals(2, newCoordinates.diagonal);
        assertEquals(2, newCoordinates.column);
    }

    public void testMoveNorth() {
        EntityRef entity = ecsManager.createEntity(coordinates);

        ecsManager.sendEventBlocking(new MoveNorthEvent(), entity);
        Coordinates newCoordinates = entity.getComponent(Coordinates.class).get();

        assertEquals(2, newCoordinates.diagonal);
        assertEquals(3, newCoordinates.column);
    }
}