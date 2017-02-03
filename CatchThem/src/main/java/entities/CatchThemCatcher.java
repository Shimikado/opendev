package entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.overlapping.Overlappable;
import utils.CatchThemMoveStrategyKeyboard;

/**
 * The GameCatcher is the playable entity of this game. It can be moved on left and right, and can catch the falling stars to get points and
 * potentially some bonuses
 * @author guntau
 *
 */
public class CatchThemCatcher extends GameMovable implements GameEntity, Overlappable,Drawable, KeyListener, Observer {

	private DrawableImage img;
	private GameCanvas canvas;
	private int point;

	protected GameData data;
	
	public CatchThemCatcher(GameData data, int x, int y) {
		this.data = data;
		this.canvas = data.getCanvas();
		this.position = new Point(x,y);
		this.img = new DrawableImage("/player.png", this.canvas);
		this.point = 0;
		initMotion();
		
	}
	
	/**
	 * initialize the controls for the player, using CatchTHemMoveStrategyKeyboard
	 */
	private void initMotion() {
		CatchThemMoveStrategyKeyboard keyboard = new CatchThemMoveStrategyKeyboard(false);
		GameMovableDriverDefaultImpl moveDriver = new GameMovableDriverDefaultImpl();
		keyboard.setSpeed(8);
		moveDriver.setStrategy(keyboard);
		moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());
		data.getCanvas().addKeyListener(keyboard);
		setDriver(moveDriver);

		data.getCanvas().addKeyListener(this);
		data.getLife().addObserver(this);
	}

	/**
	 * increasse the score by 1
	 */
	public void oneMorePoint(){
		this.data.getScore().setValue(this.data.getScore().getValue()+1);;
	}
	
	public int getPoint(){
		return this.point;
	}
	
	/**
	 * return the "hitbox" of the player
	 */
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getWidth());
		rectangle.setLocation(position.x, position.y);
		return rectangle;
	}
	
	/**
	 * Draw the character on the canvas
	 */
	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.position.x, this.position.y);

	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
