package org.strategyGame.resources;

/**
 * Stores a quantity of a given resource type.
 */
public class Storage {

    private final ResourceType type;
    
    private float capacity;
    private float amount;

    public Storage(ResourceType type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    /**
     * Returns the current storage capacity.
     */
    public float getCapacity() {
        return capacity;
    }

    /**
     * Sets the storage capacity.
     */
    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    /**
     * Returns the amount of the resource currently stored.
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Adds an amount of the resource to stored amount. If the addition would go over the stored amount, the amount is
     * set to the maximum capacity instead.
     */
    public void addResources(float additionalAmount) {
        this.amount += additionalAmount;
        if (additionalAmount > capacity) {
            additionalAmount = capacity;
        }
    }

    /**
     * Removes the specified amount of resources from the current quantity. If there isn't enough resources, nothing is
     * removed.
     * @param removalAmount the amount to be removed
     * @return whether the quantity of resources was removed
     */
    public boolean removeResources(float removalAmount) {
        if (this.amount < removalAmount) {
            //TODO tell the user that they don't have enough resources
            return false;
        }
        amount -= removalAmount;
        return true;
    }
}
