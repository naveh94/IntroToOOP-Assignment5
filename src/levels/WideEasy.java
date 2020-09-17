package levels;
import java.awt.Color;
import java.util.List;

import gameobjects.Block;
import gameobjects.Sprite;
import geometry.Point;
import geometry.Velocity;

/**
 * Level: Wide Easy's LevelInformation.
 * @author Naveh Marchoom
 */
public class WideEasy implements LevelInformation {

    /**
     * {@inheritDoc}
     */
    @Override
    public int numberOfBalls() {
        return 10;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l =  new java.util.ArrayList<>();
        for (int i = 0; i < 5; i++) {
            l.add(Velocity.fromAngleAndSpeed(Velocity.straightUpAngle() - i * 10, 6));
        }
        for (int i = 0; i < 5; i++) {
            l.add(Velocity.fromAngleAndSpeed(Velocity.straightUpAngle() + i * 10, 6));
        }
        return l;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int paddleSpeed() {
        return 5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int paddleWidth() {
        return 600;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sprite getBackground() {
        return new WideEasyBG();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Block> blocks() {
        List<Block> l = new java.util.ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Block b = new Block(new Point(25 + i * 50, 250), 50, 28);
            int red = (int) (Math.sin(0.31 * i + 0) * 127 + 128);
            int green = (int) (Math.sin(0.31 * i + 2) * 127 + 128);
            int blue = (int) (Math.sin(0.31 * i + 4) * 127 + 128);
            b.setColor(new Color(red, green, blue));
             b.setHitPoints(2);
            l.add(b);
        }
        return l;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }

}
