package utils;

import java.awt.Point;
import java.awt.event.KeyEvent;

import gameframework.motion.MoveStrategyConfigurableKeyboard;
import gameframework.motion.SpeedVector;

/**
 * Move Strategy Keyboard, overridden from {@link MoveStrategyConfigurableKeyboard}
 * Allows only left and right movement.
 * @author guntau
 *
 */
public class CatchThemMoveStrategyKeyboard extends MoveStrategyConfigurableKeyboard {
		
	
	
	public CatchThemMoveStrategyKeyboard(Boolean alwaysMove) {
		this(alwaysMove, new SpeedVector(new Point(0, 0)));
	}
	

	public CatchThemMoveStrategyKeyboard(SpeedVector speedVector) {
		this(true, speedVector);
	}
	

	public CatchThemMoveStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector) {
		this(alwaysMove, speedVector, false);
	}
	
	public CatchThemMoveStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector, Boolean combineDirections) {
		
		super(alwaysMove, speedVector, combineDirections);
		addKeyDirection(KeyEvent.VK_RIGHT, new Point(1, 0));
		addKeyDirection(KeyEvent.VK_LEFT, new Point(-1, 0));
	}
}
