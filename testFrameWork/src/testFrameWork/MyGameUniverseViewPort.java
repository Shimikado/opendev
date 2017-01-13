package testFrameWork;


import java.net.URL;

import gameframework.drawing.BackgroundImage;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;


public class MyGameUniverseViewPort extends GameUniverseViewPortDefaultImpl {
	
	protected GameData data;

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void setGameData(GameData data) {
		// TODO Auto-generated method stub
		this.data = data;
	}

	@Override
	public void setBackgroundImage(String path) {
		// TODO Auto-generated method stub
		this.background = new BackgroundImage("/black_background.png", this.data.getCanvas());
	}
	
	@Override
	public URL backgroundImage(){
		return backgroundImage("/black_background.png");
	}
}