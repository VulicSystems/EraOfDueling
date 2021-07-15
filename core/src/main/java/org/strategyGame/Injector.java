package org.strategyGame;

import org.reflections.ReflectionUtils;
import org.strategyGame.ecsStructure.GameSystem;
import org.strategyGame.ecsStructure.InjectedField;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class Injector {
    public static void injectFields(Object object, ServiceLocatorMap serviceLocatorMap) {
        AccessController.doPrivileged((PrivilegedAction<GameSystem>) () -> {
            for (Field field : ReflectionUtils.getAllFields(object.getClass(),
                    ReflectionUtils.withAnnotation(InjectedField.class))) {
                Object value = serviceLocatorMap.get(field.getType());
                if (value != null) {
                    try {
                        field.setAccessible(true);
                        field.set(object, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

            return null;
        });
    }
}
