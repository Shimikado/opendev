package utils;

import java.net.URL;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

public class CatchThemUniverseViewPort extends GameUniverseViewPortDefaultImpl {
		
	
		public CatchThemUniverseViewPort(GameData data){
			super(data);
		}
		
		
		@Override
		protected URL backgroundImage() {
			return this.getClass().getResource("/images/background2.jpg");
		}
}
