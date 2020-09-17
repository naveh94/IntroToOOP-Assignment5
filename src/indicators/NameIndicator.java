package indicators;

import biuoop.DrawSurface;
import gameobjects.Sprite;

/**
 * Level's Name indicator sprite.
 * @author Naveh Marchoom
 *
 */
public class NameIndicator implements Sprite {

    private String name;

    /**
     * Creates a new NameIndicator Object that show given String.
     * @param n String
     */
    public NameIndicator(String n) {
        this.name = n;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void drawOn(DrawSurface board) {
        board.setColor(java.awt.Color.white);
        board.drawText(board.getWidth() - this.name.length() * 11 + 30,
                15, this.name, 11);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timePassed() {
        // TODO Auto-generated method stub

    }

}
