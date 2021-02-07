package units.elves.fighter;

import units.Unit;

public class ElvishFighter implements Unit {

    private final int LEVEL;

    public ElvishFighter(int level){
        this.LEVEL = level;
    }

    @Override
    public int getLevel() {
        return LEVEL;
    }
}
