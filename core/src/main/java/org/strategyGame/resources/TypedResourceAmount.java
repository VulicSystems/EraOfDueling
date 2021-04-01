package org.strategyGame.resources;

/**
 * Represents a typed quantity of resources.
 */
public class TypedResourceAmount {
    public final ResourceType type;
    public float amount;

    public TypedResourceAmount(ResourceType type, float amount) {
        this.type = type;
        this.amount = amount;
    }
}
