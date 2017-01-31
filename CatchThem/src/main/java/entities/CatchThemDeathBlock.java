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

/**
 * Deaths Blocks are the entities under the player. Whenever a star fall in, the player lose life(s)
 * @author guntau
 *
 */
public class CatchThemDeathBlock extends GameMovable implements GameEntity, Overlappable, Drawable {
	
	protected DrawableImage img;
	protected GameCanvas canvas;
	protected GameData data;
	
	
	public CatchThemDeathBlock(GameData data,int x, int y) {
		this.canvas = data.getCanvas();
		this.img = new DrawableImage("/images/line.png", canvas);
		this.position = new Point(x,y);
		this.data = data;
		initMotion();
		
	}
	
	private void initMotion() {
		MoveStrategyStraightLine strat = new MoveStrategyStraightLine(this.position, this.position);
		strat.setSpeed(0);
		GameMovableDriverDefaultImpl moveDriver = new GameMovableDriverDefaultImpl();
		moveDriver.setStrategy(strat);
		moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());
		setDriver(moveDriver);
	}
	
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getWidth());
		rectangle.setLocation(position.x, position.y);
		return rectangle;
	}

	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.position.x, this.position.y);
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean isMovable(){
		return false;
	}

}
