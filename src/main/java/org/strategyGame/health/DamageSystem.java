package org.strategyGame.health;

import org.strategyGame.Health;
import org.strategyGame.ecsStructure.GameSystem;
import org.terasology.gestalt.entitysystem.entity.EntityRef;
import org.terasology.gestalt.entitysystem.event.EventResult;
import org.terasology.gestalt.entitysystem.event.ReceiveEvent;

/*
    This system handles the health systems of entities with a {@link Health} component
 */
public class DamageSystem  implements GameSystem{

    @ReceiveEvent(components = {Health.class})
    public EventResult damage(DamageEvent damageEvent, EntityRef entity){
        Health health = entity.getComponent(Health.class).get();
        //check to make sure health does not fall bellow zero
        health.currentHealth = (health.currentHealth > damageEvent.damageAmount)
                ? (health.currentHealth - damageEvent.damageAmount) : 0;
        entity.setComponent(health);
        return EventResult.CONTINUE;
    }

    @ReceiveEvent(components = {Health.class})
    public EventResult health(HealEvent healEvent, EntityRef entity){
        Health health = entity.getComponent(Health.class).get();
        if ((health.currentHealth + healEvent.healAmount) > health.maxHealth)
            health.currentHealth = health.maxHealth;
        else
            health.currentHealth += healEvent.healAmount;
        entity.setComponent(health);
        return EventResult.CONTINUE;
    }
}
