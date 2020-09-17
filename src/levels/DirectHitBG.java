package levels;
import biuoop.DrawSurface;
import gameobjects.Sprite;

import java.awt.Color;

/**
 * Level: Direct Hit's Background Sprite.
 * @author Naveh Marchoom
 *
 */
public class DirectHitBG implements Sprite {

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawOn(DrawSurface board) {
        board.setColor(Color.black);
        board.fillRectangle(0, 0, board.getWidth(), board.getHeight());
        board.setColor(Color.blue);
        board.drawCircle(401, 166, 70);
        board.drawCircle(401, 166, 100);
        board.drawCircle(401, 166, 130);
        board.drawLine(board.getWidth() / 2, 0, board.getWidth() / 2, 130);
        board.drawLine(board.getWidth() / 2, 202, board.getWidth() / 2, 332);
        board.drawLine(235, 166, 365, 166);
        board.drawLine(437, 166, 567, 166);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timePassed() {
        // Nothing changes.
    }

}
