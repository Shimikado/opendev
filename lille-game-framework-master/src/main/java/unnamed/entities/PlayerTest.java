package unnamed.entities;

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
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.MoveStrategyKeyboard8Dir;
import gameframework.motion.overlapping.Overlappable;

public class PlayerTest extends GameMovable implements Observer,
Overlappable, GameEntity, Drawable, KeyListener{
	
	//La taille de l'image de l'entité
	protected int spriteSize;
	
	//Canvas dans lequel se situe le joueur
	protected GameCanvas canvas;
	
	//Paramètre du jeu
	protected GameData data;

	//Gestionnaire d'affichage de l'entité
	private SpriteManagerDefaultImpl spriteManager;
	
	public PlayerTest(GameData game,int x,int y){
		super();
		this.canvas=game.getCanvas();
		this.data=game;
		this.spriteSize = data.getConfiguration().getSpriteSize();
		this.spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(
				"/images/doge.png", canvas), this.spriteSize, 1);
		MoveStrategyKeyboard keyboard = new MoveStrategyKeyboard8Dir(false);
		spriteManager.setTypes("static","les autres");
		spriteManager.setType("static");
		spriteManager.reset();
		this.setPosition(new Point(x, y));
		
		GameMovableDriverDefaultImpl moveDriver = new GameMovableDriverDefaultImpl();
		moveDriver.setStrategy(keyboard);
		setDriver(moveDriver);
		
		
		data.getCanvas().addKeyListener(this);
		data.getCanvas().addKeyListener(keyboard);

		
	}

	//Défini la hit box de l'entité ( soit la taille de son image ) et le positionne sur l'entité grâce à ses positions déclarer dans le GameMovable 
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.spriteSize, this.spriteSize);
		rectangle.setLocation(position.x * this.spriteSize, position.y
				* this.spriteSize);
		return rectangle;
	}

	//Permet de declarer un comportement  à l'entité
	public void oneStepMoveAddedBehavior() {
		
	}

	public void oneStepMove() {
		super.oneStepMove();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		keyTyped(e.getKeyCode());
		
	}
	
	public void keyTyped(int keyCode) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
	}

	@Override
	public void draw(Graphics g) {
		spriteManager.draw(g,this.position );
		this.setPosition(new Point((int)position.getX(),(int) position.getY()));
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
	
	

}
