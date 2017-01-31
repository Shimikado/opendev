package entities;

import gameframework.game.GameData;

/**
 * Blue Star falling on the level.
 * A Blue Star give one point to the player and also an extra life.
 * @author guntau
 *
 */
public class CatchThemBlueStar extends CatchThemStar {

	public CatchThemBlueStar(GameData data, int x, int y, int speed) {
		super(data, x, y, speed);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String imagePath() {
		// TODO Auto-generated method stub
		return "/images/noteB.png";
	}

}
