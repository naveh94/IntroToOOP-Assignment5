import java.util.ArrayList;
import java.util.List;

import gameobjects.GameFlow;
import levels.DirectHit;
import levels.FinalFour;
import levels.Green3;
import levels.LevelInformation;
import levels.WideEasy;

/**
 * The main class running the game.
 * @author Naveh Marchoom
 *
 */
public class Ass5Game {
    /**
     * Run the game.
     * If args empty, run levels 1-4. Else, will run levels in argument.
     * @param args levels arguement.
     */
    public static void main(String[] args) {
        GameFlow game = new GameFlow();
        List<LevelInformation> l = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
            case "1" :
                l.add(new DirectHit());
                break;
            case "2" :
                l.add(new WideEasy());
                break;
            case "3" :
                l.add(new Green3());
                break;
            case "4" :
                l.add(new FinalFour());
                break;
            default :
            }
        }
        if (l.isEmpty()) {
            l.add(new DirectHit());
            l.add(new WideEasy());
            l.add(new Green3());
            l.add(new FinalFour());
        }
        game.runLevels(l);
    }
}
