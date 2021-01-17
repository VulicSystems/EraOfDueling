package main.java.units.elves.userData;

import main.java.units.UnitType;
import main.java.units.elves.instances.ElvishFighter;

public class ElvishFighterUserData implements UnitType<ElvishFighter> {

    private int level = 1;

    @Override
    public void upgradeLevel() {
        level++;
    }

    @Override
    public ElvishFighter buildUnit() {
        return new ElvishFighter(level);
    }
}
