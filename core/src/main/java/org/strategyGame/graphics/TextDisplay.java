package org.strategyGame.graphics;


import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Displays text on the screen at a specified location.
 */
public class TextDisplay {

    private final BitmapFont bitmapFont;
    private final GlyphLayout layout;
    private final SpriteBatch batch;

    public TextDisplay(SpriteBatch batch) {
        bitmapFont = new BitmapFont();
        layout = new GlyphLayout();
        this.batch = batch;
    }

    /**
     * Displays a string at the specified horizontal and vertical location.
     */
    public void displayString(String string, float horizontalPosition, float verticalPosition) {
        bitmapFont.getData().scaleX = 1;
        bitmapFont.getData().scaleY = 1;
        layout.reset();
        layout.setText(bitmapFont, string);
        bitmapFont.draw(batch, layout, horizontalPosition, verticalPosition);
    }

    /**
     * Displays a string at the specified horizontal and vertical location, multiplied in size by the scale.
     *
     * @param scale the size multiplier
     */
    public void displayString(String string, float horizontalPosition, float verticalPosition, float scale) {
        bitmapFont.getData().scaleX = scale;
        bitmapFont.getData().scaleY = scale;
        layout.reset();
        layout.setText(bitmapFont, string);
        bitmapFont.draw(batch, layout, horizontalPosition, verticalPosition);
    }
}
