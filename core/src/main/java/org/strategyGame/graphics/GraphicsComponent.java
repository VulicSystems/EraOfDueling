package org.strategyGame.graphics;

import org.terasology.gestalt.entitysystem.component.Component;

/**
 * The graphics information for an entity. For the position, 0,0 is the bottom-left corner.
 */
public class GraphicsComponent implements Component<GraphicsComponent> {
    public int x, y, width, height;
    public String spriteName;
    public boolean isFlippedHorizontally, isFlippedVertically;

    @Override
    public void copy(GraphicsComponent other) {
        this.x = other.x;
        this.y = other.y;
        this.width = other.width;
        this.height = other.height;
        this.spriteName = other.spriteName;
        this.isFlippedHorizontally = other.isFlippedHorizontally;
        this.isFlippedVertically = other.isFlippedVertically;
    }
}
