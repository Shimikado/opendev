package unnamed.entities.ennemies;

import java.awt.Point;
import java.util.Random;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManager;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import unnamed.motion.MoveStrategyAVC;
import gameframework.motion.MoveStrategyRandom;
import gameframework.motion.MoveStrategyStraightLine;
import gameframework.motion.SpeedVector;
import unnamed.entities.Enemy;
import unnamed.entities.PlayerTest;
import unnamed.motion.MoveStrategyStraightRandom;



public class CageGood extends Enemy{
	protected Random rand = new Random();
	protected int nbStep = 3;
	protected int currentNbStep = 0;
	protected DrawableImage img;
	protected GameCanvas canvas;
	protected SpriteManager spriteManager;
	protected SpeedVector speed = SpeedVector.createNullVector();
	protected int spriteSize;

	// Waiting for an update
	protected MoveStrategyStraightLine moveStrat;
	private int scorePoints;
	
	
	public CageGood(GameData data, Point pos, Point goal) {
		super(data, pos, goal);
		this.scorePoints = 1000000 ;
		}
	@Override
	protected String imageLink() {
		return "/images/greencage.png";
	}
	@Override
	protected MoveStrategy getMoveStrategy(Point pos, Point goal) {
		//return (MoveStrategy) new MoveStrategyAVC(this.position,goal,7);
		return (MoveStrategy) new MoveStrategyStraightRandom(this.position,goal,7);
	}
	

}
