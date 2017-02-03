package groupe4.NicolasDoge.entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class BasicWall implements GameEntity, MoveBlocker, Drawable{
	
	
	private GameCanvas canvas;
	private DrawableImage image;
	private Point position;

	public BasicWall (GameData data,int posx, int posy){
		this.canvas = data.getCanvas();
		this.image=this.img("/images/dogeWall.png");
		this.position=new Point(posx,posy);
		
	}

	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.image.getWidth(), this.image.getHeight());
		rectangle.setLocation(position.x, position.y);
		return rectangle;
	}

	
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.image.getImage(), this.position.x, this.position.y);
		
	}

	
	public boolean isMovable() {
		return false;
	}
	
	public DrawableImage img(String link){
		return new DrawableImage(link,this.canvas);
		
	}

}
