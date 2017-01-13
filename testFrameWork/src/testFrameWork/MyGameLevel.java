package testFrameWork;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import gameframework.game.GameUniverse;
import gameframework.game.GameUniverseDefaultImpl;

public class MyGameLevel extends GameLevelDefaultImpl {
	
	// Fields
	protected int rows;
	protected int columns;
	protected int spriteSize;
	protected MyPlayer player;
	
	public MyGameLevel(GameData data) {
		super(data,50);
		// TODO Auto-generated constructor stub
		this.gameBoard = new MyGameUniverseViewPort();
		this.gameBoard.setGameData(data);
		this.player = new MyPlayer(data);
		this.universe = new GameUniverseDefaultImpl(data);
		this.universe.addGameEntity(player);
		this.rows = this.data.getConfiguration().getNbRows();
		this.columns = this.data.getConfiguration().getNbColumns();
		this.spriteSize = this.data.getConfiguration().getSpriteSize();
	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		this.gameBoard.setBackgroundImage("/black_background.png");
	}

}