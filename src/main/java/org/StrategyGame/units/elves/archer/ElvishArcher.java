package units.elves.archer;

import units.Unit;

public class ElvishArcher implements Unit {
    private final int LEVEL;

    public ElvishArcher(int level){
        this.LEVEL = level;
    }

    @Override
    public int getLevel() {
        return LEVEL;
    }
}
