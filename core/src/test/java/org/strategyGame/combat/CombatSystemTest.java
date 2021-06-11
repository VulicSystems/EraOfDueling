package org.strategyGame.combat;

import junit.framework.TestCase;
import org.junit.Before;
import org.strategyGame.ServiceLocatorMap;
import org.strategyGame.combat.events.AttackEvent;
import org.strategyGame.combat.systems.CombatSystem;
import org.strategyGame.ecsStructure.ECSManager;
import org.strategyGame.health.Health;
import org.strategyGame.units.components.UnitComponent;
import org.terasology.gestalt.entitysystem.component.management.ComponentManager;
import org.terasology.gestalt.entitysystem.entity.EntityRef;

/**
 * This tests the {@link CombatSystem}.
 */
public class CombatSystemTest extends TestCase {
    private ECSManager ecsManager;
    private Health health;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        ecsManager = new ECSManager(new ComponentManager(), new ServiceLocatorMap());
        health = new Health();
        health.currentHealth = 100;
        health.maxHealth = 100;
    }

    /**
     * Tests that when the chance of success is greater than the random number generated, the attack will do damage.
     */
    public void testGuaranteedSuccessAttack() {
        EntityRef entity = ecsManager.createEntity(health, new UnitComponent());
        AttackEvent attackEvent = new AttackEvent(AttackType.DEFAULT, 10, 1);

        ecsManager.sendEventBlocking(attackEvent, entity);
        Health newHealth = entity.getComponent(Health.class).get();

        assertEquals(90, newHealth.currentHealth);
        assertEquals(100, newHealth.maxHealth);
    }

    /**
     * Tests that when the chance of success is less than the random number generated, the attack will not do damage.
     */
    public void testGuaranteedFailureAttack() {
        EntityRef entity = ecsManager.createEntity(health, new UnitComponent());
        AttackEvent attackEvent = new AttackEvent(AttackType.DEFAULT, 10, 0);

        ecsManager.sendEventBlocking(attackEvent, entity);
        Health newHealth = entity.getComponent(Health.class).get();

        assertEquals(100, newHealth.currentHealth);
        assertEquals(100, newHealth.maxHealth);
    }

}
