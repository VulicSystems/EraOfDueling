package org.strategyGame.health;
import junit.framework.TestCase;
import org.strategyGame.Health;
import org.junit.Before;
import org.strategyGame.ecsStructure.ECSManager;
import org.terasology.gestalt.entitysystem.component.management.ComponentManager;
import org.terasology.gestalt.entitysystem.entity.EntityRef;

public class HealthSystemTest extends TestCase {
    private ECSManager ecsManager;
    private Health health;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        ecsManager = new ECSManager(new ComponentManager());
        health = new Health();
        health.currentHealth = 100;
        health.maxHealth = 100;
    }

    public void testDamageDealt() {
        EntityRef entity = ecsManager.createEntity(health);
        DamageEvent damageEvent = new DamageEvent();
        damageEvent.damageAmount = 10;

        ecsManager.sendEventBlocking(damageEvent, entity);
        Health newHealth = entity.getComponent(Health.class).get();

        assertEquals(90, newHealth.currentHealth);
        assertEquals(100, newHealth.maxHealth);
    }

    public void testBelowZeroDamage() {
        EntityRef entity = ecsManager.createEntity(health);
        DamageEvent damageEvent = new DamageEvent();
        damageEvent.damageAmount = 110;

        ecsManager.sendEventBlocking(damageEvent, entity);
        Health newHealth = entity.getComponent(Health.class).get();

        assertEquals(0, newHealth.currentHealth);
        assertEquals(100, newHealth.maxHealth);

    }
}
