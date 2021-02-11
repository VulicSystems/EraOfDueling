package org.strategyGame.units.elves.fighter;

import org.strategyGame.units.UnitCategory;

public class ElvishFighterUnitCategory implements UnitCategory<ElvishFighter> {

    private int level = 1;

    @Override
    public void upgradeLevel() {
        level++;
    }

    @Override
    public ElvishFighter createInstance() {
        return new ElvishFighter(level);
    }

}
