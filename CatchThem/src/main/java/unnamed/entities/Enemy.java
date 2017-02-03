package unnamed.entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;

import unnamed.entities.Enemy;
import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManager;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.MoveStrategy;
import gameframework.motion.SpeedVector;
import gameframework.motion.overlapping.Overlappable;

public abstract class Enemy extends GameMovable implements Overlappable, GameEntity, Drawable{

	protected GameCanvas canvas;
	protected SpriteManager spriteManager;
	protected SpeedVector speed = SpeedVector.createNullVector();
	protected int spriteSize;
	protected GameData data;
	protected int hitPoints;
	protected int scorePoints;
	protected int frameInvulnerability;
	
	public Enemy(GameData data, Point pos, Point goal){
		super();
	
		this.canvas = data.getCanvas();
		this.spriteSize = data.getConfiguration().getSpriteSize();
	
		DrawableImage img = new DrawableImage(this.imageLink(), canvas);
		this.spriteManager = new SpriteManagerDefaultImpl(img, this.spriteSize,1);
		this.initSpriteManager();
	
		this.setPosition(pos);
	
		this.initMotion(data, goal);
	
		this.data = data;
	}

	public void initSpriteManager() {
		this.spriteManager.setTypes("standard", "other");
		this.spriteManager.setType("standard");
		this.spriteManager.reset();
	}
	
	@Override
	public void oneStepMoveAddedBehavior() {
		
	}


	
	protected void initMotion(GameData data, Point goal) {
		GameMovableDriverDefaultImpl moveDriver = new GameMovableDriverDefaultImpl();
		moveDriver.setStrategy(this.getMoveStrategy(this.position, goal));
		moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());
		setDriver(moveDriver);
	}
	
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.spriteSize, this.spriteSize);
		rectangle.setLocation(position.x * this.spriteSize, position.y
				* this.spriteSize);
		return rectangle;
	}

	@Override
	public void draw(Graphics g) {
		this.spriteManager.draw(g, position);
		
	}

	private boolean noMoreEnemy() {
		Iterator<GameEntity> it = this.data.getUniverse().getGameEntitiesIterator();
		while(it.hasNext())
			if(it.next() instanceof Enemy)
				return false;
		return true;
	}
	
	public boolean invincible() {
		return true;
	}
	
	/**
	 * Return the link to the picture choose to represent the entity.
	 * @return the link to the picture choose to represent the entity in String format
	 */
	protected abstract String imageLink();
	
	/**
	 * Will return the MoveStrategy linked to the enemy.
	 * @param pos the position of the entity
	 * @param goal the goal of the enemy (most of the case in our game : the goal is the player)
	 * @return the MoveStrategy choose at the creation with the given param
	 */
	protected abstract MoveStrategy getMoveStrategy(Point pos, Point goal);

}
