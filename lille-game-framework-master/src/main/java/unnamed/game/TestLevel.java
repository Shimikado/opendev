package unnamed.game;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

import gameframework.game.GameEntity;
import gameframework.game.GameLevelDefaultImpl;
import unnamed.entities.BasicWall;
import unnamed.entities.PlayerTest;

import unnamed.ressources.*;


/*
 * Ce level à uniquement pour fonction de tester de créer le jeu. Il ne fait qu'initialiser le background 
 * Note: le nombre de minimum de fps est une constante dans GameLevelDefaultImpl 
 */
public class TestLevel extends GameLevelDefaultImpl {

	public TestLevel(GameData data,int frameRate) {
		super(data,frameRate);
	}

	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortTest(this.data);

		this.universe.addGameEntity(new PlayerTest(this.data,50,50));
		this.universe.addGameEntity(new BasicWall(this.data,150,150));

	}

}
