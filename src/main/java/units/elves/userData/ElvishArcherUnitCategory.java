package main.java.units.elves.userData;

import main.java.units.UnitCategory;
import main.java.units.elves.instances.ElvishArcher;

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
