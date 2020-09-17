package gameobjects;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import animations.GameLevel;
import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import hitlisteners.HitListener;
/**
 * Block object.
 * @author Naveh Marchoom
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private Point topLeftCorner;
    private double width;
    private double height;
    private int hitpoints = -1;
    private java.awt.Color color = java.awt.Color.GRAY;
    private List<HitListener> hitListeners;
    private boolean border = true;

    /**
     * Create a new block using the top left corner, the width and the height of the block.
     * @param topLeftCorner point.
     * @param width double.
     * @param height double.
     */
    public Block(Point topLeftCorner, double width, double height) {
        this.topLeftCorner = topLeftCorner;
        this.width = width;
        this.height = height;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * Get the collision rectangle of the block.
     * @return the collision rectangle of the block.
     */
    public Rectangle getCollisionRectangle() {
        return new Rectangle(this.topLeftCorner, this.width, this.height);
    }

    /**
     * Notify the block it has been hit, and return the new velocity should be set to the ball.
     * @param collisionPoint the point of collision.
     * @param currentVelocity the velocity it's been hit by.
     * @param hitter Ball
     * @return the new velocity should be set to the ball.
     */
    public Velocity hit(Point collisionPoint, Velocity currentVelocity, Ball hitter) {
        Velocity newVelocity = currentVelocity;

        if (this.hitpoints > 0) {
            this.hitpoints--;
        }

        if ((int) collisionPoint.getX() == this.topLeftCorner.getX()
                || (int) collisionPoint.getX() == this.topLeftCorner.getX() + width) {
            newVelocity.swapXDirection();
        }
        if ((int) collisionPoint.getY() == this.topLeftCorner.getY()
                || (int) collisionPoint.getY() == this.topLeftCorner.getY() + height) {
            newVelocity.swapYDirection();
        }
        this.notifyHit(hitter);
        return newVelocity;
    }

    /**
     * Draw the block on the surface.
     * @param surface the Draw Surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.topLeftCorner.getX(), (int) this.topLeftCorner.getY(),
                (int) this.width, (int) this.height);
        if (this.hitpoints > 0) {
            surface.setColor(Color.black);
            surface.drawText((int) this.topLeftCorner.getX() + (int) this.width / 2 - 2,
                    (int) (this.topLeftCorner.getY() + this.height / 2 + 3), "" + this.hitpoints, 11);
        }
        if (this.border) {
            surface.setColor(java.awt.Color.BLACK);
            surface.drawRectangle((int) this.topLeftCorner.getX(), (int) this.topLeftCorner.getY(),
                    (int) this.width, (int) this.height);
        }
    }

    /**
     * Time has passed.
     */
    public void timePassed() {
        // Does nothing; It's a block! :D
    }

    /**
     * Add this block to the game.
     * @param game the game
     */
    public void addToGame(GameLevel game) {
        game.addToEnvirnoment(this);
        game.addToSprites(this);
    }

    /**
     * Set the hit points of the block. By default 0;
     * @param hp the hit points should be set for the block.
     */
    public void setHitPoints(int hp) {
        this.hitpoints = hp;
    }

    /**
     * Set the block color to a new color.
     * @param c the color the block should set.
     */
    public void setColor(java.awt.Color c) {
        this.color = c;
    }

    /**
     * Remove this block from Game game.
     * @param game Game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * Notify all HitListeners in listeners list, that given hitter Ball hit this block.
     * @param hitter Ball
     */
    protected void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
           hl.hitEvent(this, hitter);
        }
     }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);

    }

    /**
     * Get the block current Hitpoints.
     * @return int
     */
    public int getHitpoints() {
        return this.hitpoints;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isInBlock(Point p) {
        Point bottomRightBorder = new Point(this.topLeftCorner.getX() + this.width,
                this.topLeftCorner.getY() + this.height);
        if (p.getX() > this.topLeftCorner.getX() && p.getX() < bottomRightBorder.getX()
            && p.getY() > this.topLeftCorner.getY() && p.getY() < bottomRightBorder.getY()) {
                return true;
            }
        return false;
    }

    /**
     * Set the if the block's border will apear or no.
     * @param b boolean
     */
    public void setBorder(boolean b) {
        this.border = b;
    }
}
