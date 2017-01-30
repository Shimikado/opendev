package entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.MoveStrategyStraightLine;
import gameframework.motion.overlapping.Overlappable;

public abstract class CatchThemStar extends GameMovable implements GameEntity, Overlappable, Drawable {
	
	private DrawableImage img;
	private GameCanvas canvas;
	private GameData data;
	private int speed;
	
	
	public CatchThemStar(GameData data,int x,int y,int speed) {
		this.data = data;
		this.canvas = data.getCanvas();
		this.img = new DrawableImage(imagePath(), canvas);
		this.position = new Point(x,y);
		this.speed = speed;
		initMotion(data, new Point(x,y+1000));
	}
	
	
	/**
	 * 
	 * @return the path of the image used for the Star
	 */
	protected abstract String imagePath();
	
	
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getWidth());
		rectangle.setLocation(position.x, position.y);
		return rectangle;
	}
	
	private void initMotion(GameData data, Point goal) {
		MoveStrategyStraightLine strat = new MoveStrategyStraightLine(this.position, goal);
		strat.setSpeed(speed);
		GameMovableDriverDefaultImpl moveDriver = new GameMovableDriverDefaultImpl();
		moveDriver.setStrategy(strat);
		moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());
		setDriver(moveDriver);
	}
	
	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.position.x, this.position.y);
	}

	
	public void selfDestruct(){
		this.data.getUniverse().removeGameEntity(this);
	}
	
	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
	}

}
