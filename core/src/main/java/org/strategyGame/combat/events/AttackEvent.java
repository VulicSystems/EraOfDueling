package org.strategyGame.combat.events;

import org.strategyGame.combat.AttackType;
import org.strategyGame.health.Health;
import org.strategyGame.units.components.UnitComponent;
import org.terasology.gestalt.entitysystem.event.Event;

/**
 * Represents an attack done to an entity with a {@link UnitComponent} and A {@link Health} component. If the attack
 * succeeds, damage is done to the entity.
 */
public class AttackEvent implements Event {

    public AttackType attackType;
    public int damageAmount;

    //the chance that the attack will succeed, expressed as a double between zero and one.
    public double chanceOfSuccess;

    public AttackEvent(AttackType attackType, int damageAmount, double chanceOfSuccess) {
        this.attackType = attackType;
        this.damageAmount = damageAmount;
        this.chanceOfSuccess = chanceOfSuccess;
    }
}
