package org.strategyGame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import org.strategyGame.ecsStructure.ECSManager;
import org.strategyGame.graphics.GraphicsComponent;
import org.strategyGame.graphics.GraphicsManager;
import org.strategyGame.resources.ResourceType;
import org.strategyGame.resources.TypedResourceAmount;
import org.terasology.gestalt.entitysystem.component.management.ComponentManager;

public class MyGdxGame extends ApplicationAdapter {

    private final float IDEALIZED_FRAME_LENGTH = 1.0f / 60.0f;
    private float elapsedTimeSinceLastUpdate = 0;

    private PlayerData playerData;
    private ECSManager ecsManager;
    private ServiceLocatorMap serviceLocatorMap;

    private SpriteBatch batch;
    private GraphicsManager graphicsManager;

    private OrthographicCamera camera;
    private StretchViewport viewport;

    //This can be arbitrarily set to whatever amount we want
    final float WORLD_WIDTH = 1000;
    final float WORLD_HEIGHT = 1000;
    private float aspectRatio;

    /**
     * Sets up the game.
     */
    @Override
    public void create() {
        playerData = new PlayerData();

        //Add services here
        serviceLocatorMap = new ServiceLocatorMap();

        ecsManager = new ECSManager(new ComponentManager(), serviceLocatorMap);

        batch = new SpriteBatch();
        aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();
        camera = new OrthographicCamera();
        viewport = new StretchViewport(1000, 1000, camera);
        viewport.apply();
        camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);

        graphicsManager = new GraphicsManager(batch, playerData, ecsManager);
        serviceLocatorMap.add(GraphicsManager.class, graphicsManager);

        runTestCodeSetup();
    }

    private void runTestCodeSetup() {
        //Entities for testing
        GraphicsComponent graphicsComponent = new GraphicsComponent();
        graphicsComponent.x = 0;
        graphicsComponent.y = 0;
        graphicsComponent.width = 400;
        graphicsComponent.height = 400;
        graphicsComponent.spriteName = "swordsman";
        ecsManager.createEntity(graphicsComponent);

        graphicsComponent = new GraphicsComponent();
        graphicsComponent.x = 400;
        graphicsComponent.y = 0;
        graphicsComponent.width = 400;
        graphicsComponent.height = 400;
        graphicsComponent.spriteName = "swordsman";
        graphicsComponent.isFlippedHorizontally = true;
        ecsManager.createEntity(graphicsComponent);
    }

    /**
     * Handles the bulk of the gameplay and manages the game loop.
     */
    @Override
    public void render() {
        ScreenUtils.clear(0.2f, 0.8f, 0.2f, 1);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        //Game loop
        elapsedTimeSinceLastUpdate += Gdx.graphics.getDeltaTime();
        //Updates based on the amount of conceptual frames (1/60 of a second) that have passed
        while (elapsedTimeSinceLastUpdate > IDEALIZED_FRAME_LENGTH) {
            update();
            elapsedTimeSinceLastUpdate -= IDEALIZED_FRAME_LENGTH;
        }

        runTestCodeUpdate();
        renderUpdatedGame();
    }

    private void update() {
        playerData.addResources(new TypedResourceAmount(ResourceType.WOOD, (float) (1000 / 60.0)));
        playerData.addResources(new TypedResourceAmount(ResourceType.STONE, (float) (1000 / 60.0)));
    }

    private void renderUpdatedGame() {

        graphicsManager.render();

        batch.end();
    }

    private void runTestCodeUpdate() {
        graphicsManager.displayString("WORDS", 300, 500, 5);
    }

    @Override
    public void dispose() {
        batch.dispose();
        graphicsManager.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
    }
}
