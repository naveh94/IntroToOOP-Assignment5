package indicators;

import biuoop.DrawSurface;
import gameobjects.Counter;
import gameobjects.Sprite;

/**
 * Lives Indicator sprite.
 * @author Naveh Marchoom
 *
 */
public class LivesIndicator implements Sprite {

    private Counter lives;

    /**
     * Creates a new LivesIndicator object given the livesCouner given.
     * @param livesLeft Counter
     */
    public LivesIndicator(Counter livesLeft) {
        this.lives = livesLeft;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawOn(DrawSurface board) {
        board.setColor(java.awt.Color.BLACK);
        board.fillRectangle(0, 0, board.getWidth(), 20);
        board.setColor(java.awt.Color.white);
        board.drawText(30 - (4 * (int) Math.log10(Math.abs(this.lives.getValue()))),
                15, "" + this.lives.getValue() + "", 11);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timePassed() {
        // Nothing to change.
    }

}
