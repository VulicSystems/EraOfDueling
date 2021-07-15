package org.strategyGame.graphics;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import org.strategyGame.PlayerData;
import org.strategyGame.ecsStructure.ECSManager;
import org.strategyGame.ecsStructure.InjectedField;
import org.terasology.gestalt.entitysystem.entity.EntityIterator;
import org.terasology.gestalt.entitysystem.entity.EntityRef;

import java.util.HashMap;

/**
 * This handles the graphics for the game. Entities with a {@link GraphicsComponent} are automatically rendered, and
 * text can be displayed by calling {@code displayString()}.
 */
public class GraphicsManager {

    private SpriteBatch batch;
    private TextDisplay textDisplay;

    @InjectedField
    private ECSManager ecsManager;

    private TextureAtlas textureAtlas = new TextureAtlas("sprites.txt");
    private HashMap<String, Sprite> sprites;

    public GraphicsManager(SpriteBatch batch) {
        this.batch = batch;
        batch.enableBlending();
        textDisplay = new TextDisplay(batch);

        sprites = new HashMap<>();
    }

    /**
     * Renders each entity with a {@link GraphicsComponent}.
     */
    public void render() {
        EntityIterator iterator = ecsManager.iterate(new GraphicsComponent());
        while (iterator.next()) {
            renderEntity(iterator.getEntity());
        }
    }

    /**
     * Renders a specific entity.
     */
    private void renderEntity(EntityRef entity) {
        GraphicsComponent graphicsComponent = entity.getComponent(GraphicsComponent.class).get();
        Sprite sprite = getSprite(graphicsComponent.spriteName);
        if (sprite != null) {
            sprite.setPosition(graphicsComponent.x, graphicsComponent.y);
            sprite.setFlip(graphicsComponent.isFlippedHorizontally, graphicsComponent.isFlippedVertically);
            sprite.setSize(graphicsComponent.width, graphicsComponent.height);
            sprite.draw(batch);
        }
    }

    /**
     * Retrieves a sprite instance if one already exists, or creates one if not.
     */
    private Sprite getSprite(String spriteName) {
        if (!sprites.containsKey(spriteName)) {
            Sprite sprite = textureAtlas.createSprite(spriteName);
            if (sprite != null) {
                sprites.put(spriteName, sprite);
            }
            return sprite;
        }
        return sprites.get(spriteName);
    }

    /**
     * Displays a string at the specified horizontal and vertical location.
     */
    public void displayString(String string, float horizontalPosition, float verticalPosition) {
        textDisplay.displayString(string, horizontalPosition, verticalPosition);
    }

    /**
     * Displays a string at the specified horizontal and vertical location, multiplied in size by the scale.
     *
     * @param scale the size multiplier
     */
    public void displayString(String string, float horizontalPosition, float verticalPosition, float scale) {
        textDisplay.displayString(string, horizontalPosition, verticalPosition, scale);
    }

    /**
     * Cleans up assets when the game is closed.
     */
    public void dispose() {
        textureAtlas.dispose();
    }
}
