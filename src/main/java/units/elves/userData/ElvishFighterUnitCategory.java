package main.java.units.elves.userData;

import main.java.units.UnitCategory;
import main.java.units.elves.instances.ElvishFighter;

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
