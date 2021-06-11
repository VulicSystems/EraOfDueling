package org.strategyGame.health;

import org.terasology.gestalt.entitysystem.event.Event;

/**
 * This event represents damage done to an entity.
 */
public class DamageEvent implements Event {
    public int damageAmount;

    public DamageEvent() {
    }

    public DamageEvent(int damageAmount) {
        this.damageAmount = damageAmount;
    }
}
