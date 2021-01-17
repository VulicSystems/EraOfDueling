package main.java.units.elves.userData;

import main.java.units.UnitType;
import main.java.units.elves.instances.ElvishArcher;

public class ElvishArcherUserData implements UnitType<ElvishArcher> {
    private int level = 1;

    @Override
    public void upgradeLevel() {
        level++;
    }

    @Override
    public ElvishArcher buildUnit() {
        return new ElvishArcher(level);
    }
}
