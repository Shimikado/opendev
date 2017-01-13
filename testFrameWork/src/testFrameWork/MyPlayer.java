package testFrameWork;

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
import gameframework.drawing.SpriteManager;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.MoveStrategyKeyboard8Dir;
import gameframework.motion.overlapping.Overlappable;

public class MyPlayer extends GameMovable implements Observer, Overlappable, GameEntity, Drawable, KeyListener {
	
	protected SpriteManager spriteManager;
	protected GameCanvas canvas;
	protected int spriteSize;
	protected Point direction;

	protected GameData data;

	protected int frameHit;

	protected int frameInvulnerability;
	
	public MyPlayer(GameData data) {
		super();
		this.frameInvulnerability = 0;
		this.frameHit = 0;
		this.canvas = data.getCanvas();
		this.data = data;
		this.spriteSize = data.getConfiguration().getSpriteSize();
		this.spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(
				"/modele.png", canvas), this.spriteSize, 3);
		
		this.setPosition(new Point(10, 10));

		MoveStrategyKeyboard keyboard = new MoveStrategyKeyboard8Dir();
		GameMovableDriverDefaultImpl moveDriver = new GameMovableDriverDefaultImpl();

		moveDriver.setStrategy(keyboard);
		moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());

		data.getCanvas().addKeyListener(keyboard);
		setDriver(moveDriver);

		data.getCanvas().addKeyListener(this);

		data.getLife().addObserver(this);
	}
	
	@Override
	public Rectangle getBoundingBox() {
		// TODO Auto-generated method stub
		return new Rectangle(10, 10, 10, 10);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
			e.getKeyCode();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keyPressed(e.getKeyCode());
	}

	private void keyPressed(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_SPACE: {
			Point hitPos = new Point((this.position.x + this.direction.x
					* this.spriteSize), (this.position.y + this.direction.y
					* this.spriteSize));
			String hitDir;
			if ((direction.equals(new Point(1, 0)))) {
				this.spriteManager.setType("sright");
				hitDir = "right";
			} else if ((direction.equals(new Point(-1, 0)))) {
				this.spriteManager.setType("sleft");
				hitDir = "left";
			} else if ((direction.equals(new Point(0, -1)))) {
				this.spriteManager.setType("sup");
				hitDir = "up";
			} else {
				this.spriteManager.setType("sdown");
				hitDir = "down";
			}
			break;
		}
		default:
			;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (this.frameInvulnerability % 4 == 0)
			this.spriteManager.draw(g, position);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub

	}

}
