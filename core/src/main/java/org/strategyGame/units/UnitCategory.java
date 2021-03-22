package org.strategyGame.units;

/**
 * This represents the information about a particular type of unit, and can create an individual instance of that unit.
 * This is tied to a specific user, and each user should only have one of each concrete UnitCategory.
 *
 * @param <T> the type of unit this represents
 */
public interface UnitCategory<T extends Unit> {

    /**
     * Increments the level by one. This should be called when the user spends the resources to improve their unit
     * (e.g. in the academy or something).
     */
    public void upgradeLevel();

    /**
     * Creates an instance of the type of unit that the category represents.
     *
     * @return an instance of the unit
     */
    public T createInstance();
}
