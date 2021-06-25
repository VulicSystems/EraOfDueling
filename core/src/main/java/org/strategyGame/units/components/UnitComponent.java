package org.strategyGame.units.components;

import org.terasology.gestalt.entitysystem.component.Component;

import java.util.ArrayList;

/**
 * Indicates that an entity is a game Unit, and contains the list of attacks that a unit can do.
 */
public class UnitComponent implements Component<UnitComponent> {

    public ArrayList<UnitAttackDetails> attacks = new ArrayList<>();

    @Override
    public void copy(UnitComponent other) {
        attacks.clear();
        for (UnitAttackDetails attackDetails: other.attacks) {
            this.attacks.add(new UnitAttackDetails(attackDetails));
        }
    }
}
