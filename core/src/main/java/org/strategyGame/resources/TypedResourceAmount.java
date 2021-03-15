package org.strategyGame.resources;

/**
 * Represents a typed quantity of resources.
 */
public class TypedResourceAmount {
    public final ResourceType type;
    public int amount;

    public TypedResourceAmount(ResourceType type, int amount) {
        this.type = type;
        this.amount = amount;
    }
}
