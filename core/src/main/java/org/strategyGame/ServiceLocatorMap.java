package org.strategyGame;

import java.util.HashMap;

/**
 * Basic implementation of the Service Locator pattern.
 *
 * //TODO create a Null Object for when a service does not exist.
 */
public class ServiceLocatorMap {

    private HashMap<Class<?>, Object> map;

    public ServiceLocatorMap() {
        this.map = new HashMap<>();
    }

    public <T, U extends T> void add(Class<T> type, U object) {
        map.put(type, object);
    }

    public <T> T get(Class<? extends  T> type) {
        return (T) map.get(type);
    }
}
