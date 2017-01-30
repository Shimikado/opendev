package catchthem;

import gameframework.game.Game;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import levels.CatchThemLevel1;

public class CatchThemGame extends GameDefaultImpl implements Game {

	public CatchThemGame(GameData data) {
		super(data);
		// TODO Auto-generated constructor stub
		init();
	}
	
	private void init(){
		this.data.addLevel(new CatchThemLevel1(data));
	}
	
}
