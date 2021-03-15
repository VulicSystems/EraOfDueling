package org.strategyGame.resources;

import junit.framework.TestCase;
import org.junit.Assert;

public class StorageTest extends TestCase {

    public void testSetCapacity() {
        Storage storage = new Storage(ResourceType.WOOD, 100);

        storage.setCapacity(200);

        Assert.assertEquals(storage.getCapacity(),200, 0.01);
    }

    public void testAddResources() {
        Storage storage = new Storage(ResourceType.WOOD, 100);

        storage.addResources(50);

        Assert.assertEquals(storage.getAmount(),50, 0.01);
    }

    public void testRemoveResources() {
        Storage storage = new Storage(ResourceType.WOOD, 100);

        storage.addResources(50);
        storage.removeResources(40);

        Assert.assertEquals(storage.getAmount(),10, 0.01);
    }
}