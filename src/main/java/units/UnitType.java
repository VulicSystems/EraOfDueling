package main.java.units;

public interface UnitType<T extends Unit> {
    public void upgradeLevel();
    public T buildUnit();
}
