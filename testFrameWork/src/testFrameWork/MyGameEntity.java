package testFrameWork;

import java.awt.Color;
import java.awt.Graphics;

import gameframework.game.GameData;
import gameframework.game.GameEntity;

public class MyGameEntity implements GameEntity {

	public MyGameEntity(GameData data) {
		
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
	}

	@Override
	public boolean isMovable() {
		// TODO Auto-generated method stub
		return false;
	}

}
