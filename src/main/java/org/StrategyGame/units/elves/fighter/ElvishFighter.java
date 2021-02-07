package org.StrategyGame.units.elves.fighter;

import org.StrategyGame.units.Unit;

public class ElvishFighter implements Unit {

    private final int LEVEL;

    public ElvishFighter(int level) {
        this.LEVEL = level;
    }

    @Override
    public int getLevel() {
        return LEVEL;
    }
}
