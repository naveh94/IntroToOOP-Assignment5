package indicators;

import biuoop.DrawSurface;
import gameobjects.Counter;
import gameobjects.Sprite;

/**
 * Game's Score Indicator sprite.
 * @author Naveh Marchoom
 */
public class ScoreIndicator implements Sprite {

    private Counter currentScore;

    /**
     * Creates a new ScoreIndicator object using the currentScore Counter given.
     * @param currentScore Counter
     */
    public ScoreIndicator(Counter currentScore) {
        this.currentScore = currentScore;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawOn(DrawSurface board) {
        board.setColor(java.awt.Color.white);
        board.drawText(board.getWidth() / 2 - (4 * (int) Math.log10(Math.abs(this.currentScore.getValue()))),
                15, "" + currentScore.getValue() + "", 11);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timePassed() {
        // Nothing to change.
    }
}
