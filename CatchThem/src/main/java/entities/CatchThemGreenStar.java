package entities;

import gameframework.game.GameData;

/**
 * Green Star falling on the level.
 * A Green Star give one point to the player.
 * @author guntau
 *
 */
public class CatchThemGreenStar extends CatchThemStar {

	public CatchThemGreenStar(GameData data, int x, int y, int speed) {
		super(data, x, y, speed);
	}

	@Override
	protected String imagePath() {
		return "/images/noteV.png";
	}

}
