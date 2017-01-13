package unnamed.game;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import unnamed.ressources.*;


/*
 * Ce level à uniquement pour fonction de tester de créer le jeu. Il ne fait qu'initialiser le background 
 * Note: le nombre de minimum de fps est une constante dans GameLevelDefaultImpl 
 */
public class TestLevel extends GameLevelDefaultImpl {

	public TestLevel(GameData data) {
		super(data);
	}

	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortTest(this.data);

	}

}
