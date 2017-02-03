package groupe4.NicolasDoge.game;

import java.awt.Point;
import java.util.Random;

import gameframework.drawing.GameUniverseViewPort;
import gameframework.game.GameData;

import gameframework.game.GameLevelDefaultImpl;
import groupe4.NicolasDoge.entities.BasicWall;
import groupe4.NicolasDoge.entities.PlayerTest;
import groupe4.NicolasDoge.entities.ennemies.BadCage;
import groupe4.NicolasDoge.entities.ennemies.CageGood;
import groupe4.NicolasDoge.ressources.*;


/*
 * Ce level à uniquement pour fonction de tester de créer le jeu. Il ne fait qu'initialiser le background 
 * Note: le nombre de minimum de fps est une constante dans GameLevelDefaultImpl 
 */
public class TestLevel extends GameLevelDefaultImpl {

	private int rows;
	private int columns;
	private int spriteSize;
	protected PlayerTest player;

	public TestLevel(GameData data,int frameRate) {
		super(data,frameRate);
		this.rows = this.data.getConfiguration().getNbRows();
		this.columns = this.data.getConfiguration().getNbColumns();
		this.spriteSize = this.data.getConfiguration().getSpriteSize();
		
	}

	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortTest(this.data);
		this.player=new PlayerTest(this.data,10*spriteSize,10*spriteSize);
		
		
		
		this.universe.addGameEntity(this.player);
		
		Random r = new Random();
		this.universe.addGameEntity(new CageGood(this.data,new Point((20+r.nextInt(5))*spriteSize,(10+r.nextInt(5))*spriteSize),player.getPosition()));
		
		
		this.addWalls();

	}
	
	/**
	 * Creates the side Walls and put them on the board.
	 * (Makes a call to create<Left/Bottom/Right/Top>SideWall)
	 */
	private void addWalls() {
		for (int i = 0; i < rows; i++)
			universe.addGameEntity(new BasicWall(data, 0, i*spriteSize));
		for (int i = 0; i < columns; i++)
			universe.addGameEntity(new BasicWall(data, i*spriteSize,(rows*30)-7));
		for (int i = rows; i > 0; i--)
			universe.addGameEntity(new BasicWall(data,(columns*31)-8, i*spriteSize));
		for (int i = columns; i > 0; i--)
			universe.addGameEntity(new BasicWall(data, i*spriteSize, 0));
	}

	protected GameUniverseViewPort getViewPort(){
		return this.gameBoard;
	}


	
}
