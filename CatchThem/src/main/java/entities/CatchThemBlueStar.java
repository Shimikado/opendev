package entities;

import gameframework.game.GameData;

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
