package utils;

import java.net.URL;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

public class CatchThemUniverseViewPortEnd extends GameUniverseViewPortDefaultImpl {
	
	
	public CatchThemUniverseViewPortEnd(GameData data){
		super(data);
	}
	
	/**
	 * Return specific image for the background.
	 */
	@Override
	protected URL backgroundImage() {
		return this.getClass().getResource("/images/wasted.jpg");
	}
}
