package entities;

import gameframework.game.GameData;

public class CatchThemGreenStar extends CatchThemStar {

	public CatchThemGreenStar(GameData data, int x, int y, int speed) {
		super(data, x, y, speed);
	}

	@Override
	protected String imagePath() {
		return "/images/noteV.png";
	}

}
