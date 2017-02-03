package unnamed.entities.ennemies;

import java.awt.Point;
import java.util.Random;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManager;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyRandom;
import gameframework.motion.MoveStrategyStraightLine;
import gameframework.motion.SpeedVector;
import unnamed.entities.Enemy;
import unnamed.entities.PlayerTest;
import unnamed.motion.MoveStrategyStraightRandom;



public class BadCage extends Enemy{
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
	
	
	public BadCage(GameData data, Point pos, Point goal) {
		super(data, pos, goal);
		this.scorePoints = 1000000 ;
		}
	@Override
	protected String imageLink() {
		return "/images/redcage.png";
	}
	@Override
	protected MoveStrategy getMoveStrategy(Point pos, Point goal) {
		//return new MoveStrategyAVC(this.position,goal,7);
		return new MoveStrategyStraightRandom(this.position,goal,7);
	}
	

}
