package utils;

import java.net.URL;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

/**
 * UniverseViewPort from DefaultImplementation. The only change is the URL returned by backgroundImage()
 * @author guntau
 *
 */
public class CatchThemUniverseViewPort extends GameUniverseViewPortDefaultImpl {
			
		public CatchThemUniverseViewPort(GameData data){
			super(data);
		}
		
		/**
		 * Return specific image for the background.
		 */
		@Override
		protected URL backgroundImage() {
			return this.getClass().getResource("/background3.png");
		}
}
