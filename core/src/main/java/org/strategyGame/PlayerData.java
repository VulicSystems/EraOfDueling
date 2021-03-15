package org.strategyGame;

import org.strategyGame.resources.TypedResourceAmount;
import org.strategyGame.resources.ResourceType;
import org.strategyGame.resources.Storage;

/**
 * Contains information about a player.
 */
public class PlayerData {

    private final Storage woodStorage;
    private final Storage stoneStorage;

    public PlayerData() {
        this.woodStorage = new Storage(ResourceType.WOOD, 10000);
        this.stoneStorage = new Storage(ResourceType.STONE, 10000);
    }

    public float getStorageCapacity(ResourceType type) {
        Storage storage = getStorageFromType(type);
        return storage.getCapacity();
    }

    public void setStorageCapacity(TypedResourceAmount typedResourceAmount) {
        Storage storage = getStorageFromType(typedResourceAmount.type);
        storage.setCapacity(typedResourceAmount.amount);
    }

    public float getStorageAmount(ResourceType type) {
        Storage storage = getStorageFromType(type);
        return storage.getAmount();
    }

    public void addResources(TypedResourceAmount typedResourceAmount) {
        Storage storage = getStorageFromType(typedResourceAmount.type);
        storage.addResources(typedResourceAmount.amount);
    }

    public void removeResources(TypedResourceAmount typedResourceAmount) {
        Storage storage = getStorageFromType(typedResourceAmount.type);
        storage.removeResources(typedResourceAmount.amount);
    }

    private Storage getStorageFromType(ResourceType type) {
        if (type == ResourceType.WOOD) {
            return woodStorage;
        }
        if (type == ResourceType.STONE) {
            return stoneStorage;
        }
        return null;
    }
}
