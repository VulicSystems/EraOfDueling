package org.strategyGame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import org.strategyGame.ecsStructure.ECSManager;
import org.strategyGame.graphics.GraphicsComponent;
import org.strategyGame.graphics.GraphicsManager;
import org.strategyGame.resources.ResourceType;
import org.strategyGame.resources.TypedResourceAmount;
import org.terasology.gestalt.entitysystem.component.management.ComponentManager;
import org.terasology.gestalt.entitysystem.entity.EntityRef;

public class MyGdxGame extends ApplicationAdapter {

    private final float IDEALIZED_FRAME_LENGTH = 1.0f / 60.0f;
    private float elapsedTimeSinceLastUpdate = 0;
    private PlayerData playerData;
    private ECSManager ecsManager;

    private SpriteBatch batch;
    private GraphicsManager graphicsManager;

    /**
     * Sets up the game.
     */
    @Override
    public void create() {
        playerData = new PlayerData();
        ecsManager = new ECSManager(new ComponentManager());

        batch = new SpriteBatch();
        graphicsManager = new GraphicsManager(batch, playerData, ecsManager);

        //Entities for testing
        GraphicsComponent graphicsComponent = new GraphicsComponent();
        graphicsComponent.x = 0;
        graphicsComponent.y = 0;
        graphicsComponent.spriteName = "swordsman";
        ecsManager.createEntity(graphicsComponent);


        graphicsComponent = new GraphicsComponent();
        graphicsComponent.x = 300;
        graphicsComponent.y = 0;
        graphicsComponent.spriteName = "swordsman";
        graphicsComponent.isFlippedHorizontally = true;
        ecsManager.createEntity(graphicsComponent);
    }

    /**
     * Handles the bulk of the gameplay and manages the game loop.
     */
    @Override
    public void render() {

        //Game loop
        elapsedTimeSinceLastUpdate += Gdx.graphics.getDeltaTime();
        //Updates based on the amount of conceptual frames (1/60 of a second) that have passed
        while (elapsedTimeSinceLastUpdate > IDEALIZED_FRAME_LENGTH) {
            update();
            elapsedTimeSinceLastUpdate -= IDEALIZED_FRAME_LENGTH;
        }

        renderUpdatedGame();
    }

    private void update() {
        playerData.addResources(new TypedResourceAmount(ResourceType.WOOD, (float) (1000 / 60.0)));
        playerData.addResources(new TypedResourceAmount(ResourceType.STONE, (float) (1000 / 60.0)));
    }

    private void renderUpdatedGame() {
        ScreenUtils.clear(0.2f, 0.8f, 0.2f, 1);

        batch.begin();

        graphicsManager.render();

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        graphicsManager.dispose();
    }
}
