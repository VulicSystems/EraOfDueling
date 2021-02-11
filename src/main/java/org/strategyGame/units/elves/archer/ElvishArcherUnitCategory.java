package org.StrategyGame.units.elves.archer;

import org.StrategyGame.units.UnitCategory;

public class ElvishArcherUnitCategory implements UnitCategory<ElvishArcher> {
    private int level = 1;

    @Override
    public void upgradeLevel() {
        level++;
    }

    @Override
    public ElvishArcher createInstance() {
        return new ElvishArcher(level);
    }

}
