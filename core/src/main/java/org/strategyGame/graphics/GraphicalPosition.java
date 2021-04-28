package org.strategyGame.graphics;

import org.terasology.gestalt.entitysystem.component.Component;

/**
 * The position of an entity in terms of graphics. 0,0 is the bottom-left corner
 */
public class GraphicalPosition implements Component<GraphicalPosition> {
    public int x, y;

    @Override
    public void copy(GraphicalPosition other) {
        this.x = other.x;
        this.y = other.y;
    }
}
