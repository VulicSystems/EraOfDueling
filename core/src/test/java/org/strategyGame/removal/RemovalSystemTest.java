package org.strategyGame.removal;

import junit.framework.TestCase;
import org.junit.Before;
import org.strategyGame.ServiceLocatorMap;
import org.strategyGame.ecsStructure.ECSManager;
import org.strategyGame.health.DamageEvent;
import org.strategyGame.health.Health;
import org.terasology.gestalt.entitysystem.component.management.ComponentManager;
import org.terasology.gestalt.entitysystem.entity.EntityRef;

/**
 * Tests the {@link RemovalSystem}.
 */
public class RemovalSystemTest extends TestCase {
    private ECSManager ecsManager;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        ecsManager = new ECSManager(new ComponentManager(), new ServiceLocatorMap());
    }

    /**
     * Tests than an entity is removed when it receives a {@link RemoveEvent}.
     */
    public void testRemoval() {
        EntityRef entity = ecsManager.createEntity();
        RemoveEvent removeEvent = new RemoveEvent();

        ecsManager.sendEventBlocking(removeEvent, entity);

        assertFalse(entity.exists());
    }

    /**
     * Tests than an entity is removed when it drops to zero health.
     */
    public void testRemovalOnZeroHealth() {
        Health health = new Health();
        health.currentHealth = 100;
        health.maxHealth = 100;
        EntityRef entity = ecsManager.createEntity(health);
        DamageEvent damageEvent = new DamageEvent(health.currentHealth);

        ecsManager.sendEventBlocking(damageEvent, entity);

        assertFalse(entity.exists());
    }
}