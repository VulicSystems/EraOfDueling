package org.strategyGame.ecsStructure;

import org.strategyGame.movement.Coordinates;
import org.strategyGame.health.Health;
import org.strategyGame.health.DamageSystem;
import org.strategyGame.movement.MovementSystem;
import org.terasology.gestalt.entitysystem.component.Component;
import org.terasology.gestalt.entitysystem.component.management.ComponentManager;
import org.terasology.gestalt.entitysystem.component.store.ArrayComponentStore;
import org.terasology.gestalt.entitysystem.component.store.ComponentStore;
import org.terasology.gestalt.entitysystem.component.store.ConcurrentComponentStore;
import org.terasology.gestalt.entitysystem.entity.EntityIterator;
import org.terasology.gestalt.entitysystem.entity.EntityManager;
import org.terasology.gestalt.entitysystem.entity.EntityRef;
import org.terasology.gestalt.entitysystem.entity.manager.CoreEntityManager;
import org.terasology.gestalt.entitysystem.event.Event;
import org.terasology.gestalt.entitysystem.event.EventSystem;
import org.terasology.gestalt.entitysystem.event.impl.EventReceiverMethodSupport;
import org.terasology.gestalt.entitysystem.event.impl.EventSystemImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * A wrapper class to handle interactions with the gestalt ECS library.
 */
public class ECSManager {

    private final EntityManager entityManager;
    private final EventSystem eventSystem = new EventSystemImpl();

    //Registering a system with this adds it to a list of systems managed by the gestalt framework, which allows that
    //system to process events.
    private final EventReceiverMethodSupport eventReceiverMethodSupport = new EventReceiverMethodSupport();


    public ECSManager(ComponentManager componentManager) {
        List<ComponentStore<?>> componentStores = new ArrayList<>();

        //TODO: have this automatically search for Component classes, rather than having to hardcode each
        componentStores.add(new ConcurrentComponentStore<>(new ArrayComponentStore<>(componentManager.getType(Coordinates.class))));
        componentStores.add(new ConcurrentComponentStore<>(new ArrayComponentStore<>(componentManager.getType(Health.class))));

        entityManager = new CoreEntityManager(componentStores);

        //TODO have this automatically search for each System, rather than having to hardcode each
        eventReceiverMethodSupport.register(new MovementSystem(), eventSystem);
        eventReceiverMethodSupport.register(new DamageSystem(), eventSystem);
    }

    /**
     * Creates an entity with a given list of components.
     */
    public EntityRef createEntity(Component... components) {
        return entityManager.createEntity(components);
    }

    /**
     * Creates an iterator that iterates over entities that have a given list of components.
     *
     * @param components the components to filter by
     */
    public EntityIterator iterate(Component... components) {
        return entityManager.iterate(components);
    }

    /**
     * Sends an event to a given entity, then waits until the event has been processed.
     */
    public void sendEventBlocking(Event event, EntityRef entity) {
        eventSystem.send(event, entity);
        eventSystem.processEvents();
    }

    /**
     * Sends an event to a given entity. This is processed asynchronously, so if later processing requires the event to
     * have been processed, {@code processEvents()} should be called before the dependent code.
     */
    public void sendEvent(Event event, EntityRef entity) {
        eventSystem.send(event, entity);
    }

    /**
     * Sends an event to each entity with a given composition of components. This is processed asynchronously, so if
     * later processing requires the event to have been processed, {@code processEvents()} should be called before the
     * dependent code.
     *
     * @param event      the event to be sent
     * @param components the components that identify the entities to receive the event
     */
    public void sendEvent(Event event, Component... components) {
        EntityIterator iterator = iterate(components);
        while (iterator.next()) {
            sendEvent(event, iterator.getEntity());
        }
    }

    /**
     * Sends an event to each entity with a given composition of components. After sending all the events, this method
     * will block until they have been processed.
     *
     * @param event      the event to be sent
     * @param components the components that identify the entities to receive the event
     */
    public void sendEventBlocking(Event event, Component... components) {
        EntityIterator iterator = iterate(components);
        while (iterator.next()) {
            sendEvent(event, iterator.getEntity());
        }
        eventSystem.processEvents();
    }

    /**
     * Blocks until all events have been processed.
     */
    public void processEvents() {
        eventSystem.processEvents();
    }
}
