package levels;

import java.util.Random;

import entities.CatchThemBlueStar;
import entities.CatchThemCatcher;
import entities.CatchThemDeathBlock;
import entities.CatchThemGreenStar;
import entities.CatchThemWall;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import utils.CatchThemUniverseViewPort;

public class CatchThemLevel1 extends GameLevelDefaultImpl {

	protected int rows;
	protected int columns;
	protected int spriteSize;
	
	
	
	public CatchThemLevel1(GameData data) {
		super(data,40);
		this.rows = this.data.getConfiguration().getNbRows();
		this.columns = this.data.getConfiguration().getNbColumns();
		this.spriteSize = this.data.getConfiguration().getSpriteSize();
		
		// if the numbers of columns is not pair, then we decrement it for a better display
		if(columns/2 != 0)
			columns--;
		if(rows/2 != 0)
			rows--;
	}

	@Override
	protected void init() {
		this.gameBoard = new CatchThemUniverseViewPort(data);
		createWalls();
		this.universe.addGameEntity(new CatchThemCatcher(data,(columns/2)*this.spriteSize,(rows-5)*this.spriteSize));
	}
	
	private void createRandomStar(){
		Random rand = new Random();
		int chanceCreation = rand.nextInt(100);
		int typeofStar = rand.nextInt(2);
		if(chanceCreation > 95){
			int speed = rand.nextInt(3)+2;
			int positionX = rand.nextInt((columns-2)*spriteSize);
			
			switch(typeofStar){
			case 0:
				this.universe.addGameEntity(new CatchThemBlueStar(data, positionX+1*spriteSize+1, 0, speed));
				break;
				
			default:
				this.universe.addGameEntity(new CatchThemGreenStar(data, positionX+1*spriteSize+1, 0, speed));
			}
			
		}
	}
	
	@Override
	public void run(){
		stopGameLoop = false;
		// main game loop :
		long start;
		while (!stopGameLoop && !this.isInterrupted()) {
			start = System.currentTimeMillis();
			gameBoard.paint();
			universe.allOneStepMoves();
			universe.processAllOverlaps();
			createRandomStar();
			long sleepTime = minimumDelayBetweenCycles
					- (System.currentTimeMillis() - start);
			if (sleepTime > 0) {
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					// that's ok, we just didn't managed to finish sleeping
				}
			}
		}
	}
	
	/**
	 * Create the walls around the level
	 */
	private void createWalls(){
		
		for (int i = 0; i < rows; i=i+2){
			//top wall useless here
			//universe.addGameEntity(new CatchThemWall(data, i*spriteSize,0));
			
			//bottom wall
			universe.addGameEntity(new CatchThemDeathBlock(data, i*spriteSize,(rows-2)*spriteSize));
		}
		
		for (int i = 0; i < columns; i=i+2){
			
			//left wall
			universe.addGameEntity(new CatchThemWall(data, 0,i*spriteSize));
			
			//right wall
			universe.addGameEntity(new CatchThemWall(data, (columns-1)*spriteSize,i*spriteSize));
			
		}

	}

}
