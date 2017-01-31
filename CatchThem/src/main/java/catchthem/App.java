package catchthem;

import gameframework.game.GameData;
import gameframework.gui.GameStatusBarElement;
import gameframework.gui.GameWindow;
import utils.CatchThemConfiguration;

/**
 * Main Application used to start the game.
 * This class contains the main used by Maven, among others
 *
 */
public class App 
{
	/**
	 * main class
	 * @param args not used here.
	 */
    public static void main( String[] args )
    {
        CatchThemConfiguration config = new CatchThemConfiguration();
        GameData data = new GameData(config);
        CatchThemGame game = new CatchThemGame(data);
        GameStatusBarElement<Integer> score = new GameStatusBarElement<Integer>(
				"Score : ", data.getScore());
		GameStatusBarElement<Integer> life = new GameStatusBarElement<Integer>(
				"Life : ", data.getLife());

		GameWindow w = new GameWindow("Catch Them !", data.getCanvas(),
				config, life, score);
		w.createGUI();
        game.start();
    }
}
