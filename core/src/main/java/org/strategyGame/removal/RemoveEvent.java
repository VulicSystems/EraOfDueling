package org.strategyGame.removal;

import org.terasology.gestalt.entitysystem.event.Before;
import org.terasology.gestalt.entitysystem.event.Event;

/**
 * Tells the {@link RemovalSystem} to remove an entity. If anything should happen involving the entity before it is
 * deleted, the annotation {@link Before} should be used.
 */
public class RemoveEvent implements Event {
}
