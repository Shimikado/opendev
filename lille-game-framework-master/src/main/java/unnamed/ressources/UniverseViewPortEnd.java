package unnamed.ressources;

import java.net.URL;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

public class UniverseViewPortEnd extends
GameUniverseViewPortDefaultImpl{
	
	
	public UniverseViewPortEnd(GameData data) {
		super(data);
	}

	@Override
	protected URL backgroundImage() {

		return backgroundImage("/images/back1.png");

	}
}
