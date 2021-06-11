package org.strategyGame.combat.systems;

import org.strategyGame.combat.events.AttackEvent;
import org.strategyGame.ecsStructure.ECSManager;
import org.strategyGame.ecsStructure.GameSystem;
import org.strategyGame.ecsStructure.InjectedField;
import org.strategyGame.health.DamageEvent;
import org.strategyGame.health.Health;
import org.strategyGame.units.components.UnitComponent;
import org.terasology.gestalt.entitysystem.entity.EntityRef;
import org.terasology.gestalt.entitysystem.event.EventResult;
import org.terasology.gestalt.entitysystem.event.ReceiveEvent;

import java.util.Random;

/**
 * This system handles attacks and determines whether damage is dealt. If damage should be dealt because of the attack,
 * this sends a {@link DamageEvent} to the entity.
 */
public class CombatSystem implements GameSystem {

    //TODO replace with a better random number generator
    Random random = new Random();

    @InjectedField
    private ECSManager ecsManager;

    @ReceiveEvent(components = {Health.class, UnitComponent.class})
    public EventResult processAttack(AttackEvent event, EntityRef entity) {
        if (random.nextDouble() <= event.chanceOfSuccess) {
            ecsManager.sendEventBlocking(new DamageEvent(event.damageAmount), entity);
        }
        return EventResult.CONTINUE;
    }
}
