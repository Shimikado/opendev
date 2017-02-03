package levels;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import utils.CatchThemUniverseViewPortEnd;

public class CatchThemLevelEnd extends GameLevelDefaultImpl {
	
	
	protected int rows;
	protected int columns;
	protected int spriteSize;
	
	public CatchThemLevelEnd(GameData data) {
		super(data,40);
		this.rows = this.data.getConfiguration().getNbRows();
		this.columns = this.data.getConfiguration().getNbColumns();
		this.spriteSize = this.data.getConfiguration().getSpriteSize();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		this.gameBoard = new CatchThemUniverseViewPortEnd(data);
		this.universe.removeAllGameEntities();
	}

}
