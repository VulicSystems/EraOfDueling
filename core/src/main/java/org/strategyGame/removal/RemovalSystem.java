package org.strategyGame.removal;

import org.strategyGame.ecsStructure.ECSManager;
import org.strategyGame.ecsStructure.GameSystem;
import org.strategyGame.ecsStructure.InjectedField;
import org.strategyGame.health.Health;
import org.strategyGame.health.ZeroHealthEvent;
import org.terasology.gestalt.entitysystem.entity.EntityRef;
import org.terasology.gestalt.entitysystem.event.EventResult;
import org.terasology.gestalt.entitysystem.event.ReceiveEvent;

/**
 * This system handles the removal of entities.
 */
public class RemovalSystem implements GameSystem {

    @InjectedField
    private ECSManager ecsManager;

    /**
     * When an entity reaches zero health, this sends a {@link RemoveEvent} to the entity, signaling that it should be
     * deleted.
     */
    @ReceiveEvent(components = Health.class)
    public EventResult removeOnZeroHealth(ZeroHealthEvent event, EntityRef entity) {
        ecsManager.sendEventBlocking(new RemoveEvent(), entity);
        return EventResult.COMPLETE;
    }

    /**
     * Deletes an entity and all the components attached to it.
     */
    @ReceiveEvent
    public EventResult removeEntity(RemoveEvent event, EntityRef entity) {
        entity.delete();
        return EventResult.COMPLETE;
    }
}
