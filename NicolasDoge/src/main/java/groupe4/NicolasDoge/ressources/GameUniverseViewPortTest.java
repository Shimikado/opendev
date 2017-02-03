package  groupe4.NicolasDoge.ressources;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

import java.net.URL;




/**
 * Cette classe à pour fonction de draw toutes les entitées et le background dans le canvas principal grace à sa méthode paint
 * @author malamelli
 *
 */
public class GameUniverseViewPortTest extends
		GameUniverseViewPortDefaultImpl {

	
	
	public GameUniverseViewPortTest(GameData data) {
		super(data);
	}

	@Override
	protected URL backgroundImage() {

		return backgroundImage("/images/back2.png");

	}
}
