package catchthem;

import gameframework.game.Game;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import levels.CatchThemLevel1;

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
	}
	
}
