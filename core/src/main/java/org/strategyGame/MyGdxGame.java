package org.strategyGame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import org.strategyGame.graphics.GraphicsManager;
import org.strategyGame.graphics.TextDisplay;
import org.strategyGame.resources.ResourceType;
import org.strategyGame.resources.TypedResourceAmount;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    Texture img;

    private GraphicsManager graphicsManager;

    private final float IDEALIZED_FRAME_LENGTH = 1.0f / 60.0f;
    private float elapsedTimeSinceLastUpdate = 0;
    private PlayerData playerData;

    /**
     * Sets up the game.
     */
    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        playerData = new PlayerData();
        graphicsManager = new GraphicsManager(batch, playerData);
    }

    /**
     * Handles the bulk of the gameplay and manages the game loop
     */
    @Override
    public void render() {
        ScreenUtils.clear(0.2f, 0.8f, 0.2f, 1);

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
        batch.begin();

        graphicsManager.render();

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
