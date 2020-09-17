package gameobjects;

import java.util.List;

import animations.GameLevel;
import animations.GameOverScreen;
import animations.WinningScreen;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import levels.LevelInformation;
/**
 * GameFlow object that runs several levels.
 * @author Naveh Marchoom
 */
public class GameFlow {

    private GUI gui;
    private AnimationRunner ar;
    private KeyboardSensor ks;

    private Counter lives = new Counter(7);
    private Counter score = new Counter(0);

    /**
     * Construct a new GameFlow object with given variables.
     * @param ar AnimationRunner
     * @param ks KeyboardSensor
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.gui = new GUI("Arcanoid", 800, 600);
        this.ar = ar;
        this.ks = ks;
    }

    /**
     * Construct a new GameFlow object without giving variables.
     */
    public GameFlow() {
        this.gui = new GUI("Arcanoid", 800, 600);
        this.ar = new AnimationRunner(this.gui, 60);
        this.ks = this.gui.getKeyboardSensor();
    }

    /**
     * Run the levels in the levels list.
     * @param levels List<LevelInformation>
     */
    public void runLevels(List<LevelInformation> levels) {
        GameLevel game = new GameLevel(this.ar, this.gui, this.ks);
        for (LevelInformation level : levels) {
            game.initialize(800, 600, level, this.score, this.lives);
            game.run();
            if (lives.getValue() == 0) {
                this.ar.run(new GameOverScreen(this.ks, this.score.getValue()));
                break;
            }
        }
        if (lives.getValue() > 0) {
            this.ar.run(new WinningScreen(this.ks, this.score.getValue()));
        }
        gui.close();
    }

}
