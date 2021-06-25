package org.strategyGame.units.components;

import org.strategyGame.combat.AttackType;

/**
 * Represents the data about a type of attack move that a unit can do.
 */
public class UnitAttackDetails {

    private final int attackDamage;
    private final AttackType attackType;
    private final double chanceOfHitting;

    public UnitAttackDetails(int attackDamage, AttackType attackType, double chanceOfHitting) {
        this.attackDamage = attackDamage;
        this.attackType = attackType;
        if (chanceOfHitting > 1) {
            chanceOfHitting = 1;
        }
        if (chanceOfHitting < 0) {
            chanceOfHitting = 0;
        }
        this.chanceOfHitting = chanceOfHitting;
    }

    public UnitAttackDetails(UnitAttackDetails otherAttackDetails) {
        this.attackDamage = otherAttackDetails.getAttackDamage();
        this.attackType = otherAttackDetails.getAttackType();
        this.chanceOfHitting = otherAttackDetails.getChanceOfHitting();
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public double getChanceOfHitting() {
        return chanceOfHitting;
    }
}
