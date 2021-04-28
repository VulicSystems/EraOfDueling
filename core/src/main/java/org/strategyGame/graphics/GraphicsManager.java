package org.strategyGame.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.strategyGame.PlayerData;
import org.strategyGame.resources.ResourceType;

public class GraphicsManager {

    private SpriteBatch batch;
    private TextDisplay textDisplay;
    private PlayerData playerData;

    public GraphicsManager(SpriteBatch batch, PlayerData playerData) {
        this.batch = batch;
        textDisplay = new TextDisplay(batch);
        this.playerData = playerData;
    }

    public void render() {
        textDisplay.displayString(((int) playerData.getStorageAmount(ResourceType.WOOD)) + " wood", Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 2);
        batch.draw(new Texture("HexTile.png"), 100, 10);
    }

}
