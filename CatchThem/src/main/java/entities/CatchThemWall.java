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
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.overlapping.Overlappable;

/**
 * Walls on the left and the right of the level. They stop the Catcher from leaving the visible space
 * @author guntau
 *
 */
public class CatchThemWall extends GameMovable implements MoveBlocker, Drawable,Overlappable, GameEntity {

	protected DrawableImage img;
	protected GameCanvas canvas;
	protected Point position;
	
	
	public CatchThemWall(GameData data,int x, int y) {
		// TODO Auto-generated constructor stub
		this.canvas = data.getCanvas();
		this.position = new Point(x,y);
		this.img = new DrawableImage("/wall.png", canvas);
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
