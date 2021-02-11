package org.strategyGame.units.elves.fighter;

import org.strategyGame.units.Unit;

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
