package unnamed.game;

import java.awt.Point;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

import gameframework.game.GameEntity;
import gameframework.game.GameLevelDefaultImpl;
import unnamed.entities.BasicWall;
import unnamed.entities.PlayerTest;
import unnamed.entities.ennemies.Cage;
import unnamed.ressources.*;


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
		System.out.println(this.player.getPosition().toString());
		
		this.universe.addGameEntity(new Cage(this.data,new Point(13*spriteSize,13*spriteSize),player.getPosition()));
		
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
			universe.addGameEntity(new BasicWall(data, i*spriteSize,(rows-1)*spriteSize));
		for (int i = rows; i > 0; i--)
			universe.addGameEntity(new BasicWall(data,(columns-1)*spriteSize, i*spriteSize));
		for (int i = columns; i > 0; i--)
			universe.addGameEntity(new BasicWall(data, i*spriteSize, 0));
	}



	
}
