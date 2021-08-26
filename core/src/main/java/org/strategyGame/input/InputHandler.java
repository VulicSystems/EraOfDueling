package org.strategyGame.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import org.strategyGame.ecsStructure.ECSManager;
import org.strategyGame.ecsStructure.InjectedField;
import org.strategyGame.graphics.GraphicsManager;

/**
 * This class handles user input
 */
public class InputHandler implements InputProcessor {

    @InjectedField
    private GraphicsManager graphicsManager;

    public static class TouchInfo {
        public float touchX = 0;
        public float touchY = 0;
        public boolean touched = false;
    }

    //TODO remove this - for testing only
    public TouchInfo touchInfo = new TouchInfo();

    //TODO remove this - for testing only
    public void render() {
        if (touchInfo.touched) {
            String message = Float.toString(touchInfo.touchX) + ", " + Float.toString(touchInfo.touchY);
            graphicsManager.displayStringUsingLibgdxCoordinates(message, touchInfo.touchX, touchInfo.touchY, 3);
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //TODO remove this - for testing only
        touchInfo.touchX = screenX;
        touchInfo.touchY = Gdx.graphics.getHeight() - screenY;
        touchInfo.touched = true;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //TODO remove this - for testing only
        touchInfo.touchX = 0;
        touchInfo.touchY = 0;
        touchInfo.touched = false;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        // TODO Auto-generated method stub
        return false;
    }

}
