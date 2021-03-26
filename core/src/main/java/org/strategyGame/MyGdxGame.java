package org.strategyGame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import org.strategyGame.graphics.TextDisplay;
import org.strategyGame.resources.ResourceType;
import org.strategyGame.resources.TypedResourceAmount;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    Texture img;

    private TextDisplay textDisplay;

    private final float IDEALIZED_FRAME_LENGTH = 1.0f / 60.0f;
    private float elapsedTimeSinceLastUpdate = 0;

    PlayerData playerData;

    /**
     * Sets up the game.
     */
    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        playerData = new PlayerData();
        textDisplay = new TextDisplay(batch);
    }

    /**
     * Handles the bulk of gameplay - i.e.
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

        textDisplay.displayString(((int) playerData.getStorageAmount(ResourceType.WOOD)) + " wood", 250, 250, 2);
        batch.draw(new Texture("HexTile.png"), 100, 10);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
