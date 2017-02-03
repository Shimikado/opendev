package catchthem;

import gameframework.game.Game;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameStatusBarElement;
import gameframework.gui.GameWindow;
import levels.CatchThemLevel1;
import levels.CatchThemLevelEnd;
import utils.CatchThemConfiguration;

/**
 * Game class used to create and start a game.
 * @see GameDefaultImpl for more information
 * @author Guntau
 *
 */
public class CatchThemGame extends GameDefaultImpl implements Game {
	
	/**
	 * Constructor from GameDefaultImpl, and call the init method.
	 * @param data is the GameData generated from CatchThemConfiguration
	 */
	public CatchThemGame(GameData data) {
		super(data);
		// TODO Auto-generated constructor stub
		init();
	}
	
	/**
	 * Add the level(s) to the GameData
	 */
	private void init(){
		this.data.addLevel(new CatchThemLevel1(data));
		this.data.addLevel(new CatchThemLevelEnd(data));
	}
	
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
