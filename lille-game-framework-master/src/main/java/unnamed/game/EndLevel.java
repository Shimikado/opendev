package unnamed.game;


import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import unnamed.ressources.UniverseViewPortEnd;

public class EndLevel extends GameLevelDefaultImpl  {

	public EndLevel(GameData data, int frameRate) {
		super(data,frameRate);
	}

	@Override
	protected void init() {
		this.gameBoard = new UniverseViewPortEnd(this.data);
		data.getEndOfGame().setValue(true);
	}

}
