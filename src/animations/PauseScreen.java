package animations;

import java.awt.Color;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gameobjects.SpriteCollection;

/**
 * PauseScreen Animation.
 * @author Naveh Marchoom
 */
public class PauseScreen implements Animation {

    private KeyboardSensor keyboard;
    private SpriteCollection background = null;
    private boolean stop;

    /**
     * Create a new Pause Screen animation using the KeyboardSensor given.
     * @param ks KeyboardSensor
     */
    public PauseScreen(KeyboardSensor ks) {
          this.keyboard = ks;
          this.stop = false;
    }

    /**
     * Create a new Pause Screen animation using the KeyboardSensor given,
     * and the SpriteCollection given as a background.
     * @param ks KeyboardSensor
     * @param bg SpriteCollection
     */
    public PauseScreen(KeyboardSensor ks, SpriteCollection bg) {
        this.keyboard = ks;
        this.stop = false;
        this.background = bg;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doOneFrame(DrawSurface board) {
        if (this.background != null) {
            this.background.drawOnAll(board);
            board.setColor(Color.BLACK);
            for (int i = 0; i < board.getWidth() + 200; i += 4) {
                board.drawLine(i, 20, i - 200, board.getHeight());
                board.drawLine(i + 1, 20, i + 1 - 200, board.getHeight());
            }
        } else {
            board.setColor(Color.BLACK);
            board.fillRectangle(0, 0, board.getWidth(), board.getHeight());
        }

        board.setColor(Color.BLACK);
        board.drawText(board.getWidth() / 2 - 118, board.getHeight() / 2 + 2, "Game Paused", 40);
        board.drawText(board.getWidth() / 2 - 238, board.getHeight() / 2 + 42, "Press \"SPACE\" to continue", 40);
        board.setColor(Color.WHITE);
        board.drawText(board.getWidth() / 2 - 120, board.getHeight() / 2, "Game Paused", 40);
        board.drawText(board.getWidth() / 2 - 240, board.getHeight() / 2 + 40, "Press \"SPACE\" to continue", 40);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}
