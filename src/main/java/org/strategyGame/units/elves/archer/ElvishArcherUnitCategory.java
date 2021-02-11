package org.strategyGame.units.elves.archer;

import org.strategyGame.units.UnitCategory;

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
