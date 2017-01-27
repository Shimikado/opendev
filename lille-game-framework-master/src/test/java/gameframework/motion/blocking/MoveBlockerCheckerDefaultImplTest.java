package gameframework.motion.blocking;

import gameframework.game.GameData;
import gameframework.motion.GameMovable;
import gameframework.motion.SpeedVector;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class MoveBlockerCheckerDefaultImplTest {

	MoveBlockerCheckerDefaultImpl checker;
	SpeedVector speedVector;
	GameMovable movable;
	int width = 100;
	int height = 200;
	List<MoveBlocker> foundBlockers = new ArrayList<MoveBlocker>();

	@Before
	public void createMovable() {
		movable = new GameMovable() {

			@Override
			public Rectangle getBoundingBox() {
				return new Rectangle(0, 0, width, height);
			}

			@Override
			public void oneStepMoveAddedBehavior() {
			}
		};
	}

	@Before
	public void createChecker() {
		checker = new MoveBlockerCheckerDefaultImpl();
		checker.setMoveBlockerRules(new MoveBlockerRulesApplier() {

			@Override
			public boolean moveValidationProcessing(GameMovable m,
					List<MoveBlocker> blockers) {
				foundBlockers = blockers;
				// by default, a blocker invalidates the move
				return false;
			}

			@Override
			public void setGameData(GameData gameData) {
			}
		});
	}

	public void setSpeedVector(int x, int y, int speed) {
		speedVector = new SpeedVector(new Point(x, y), speed);
	}

	private MoveBlocker createMoveBlocker(final int x, final int y,
			final int width, final int height) {
		return new MoveBlocker() {

			@Override
			public Rectangle getBoundingBox() {
				return new Rectangle(x, y, width, height);
			}

			@Override
			public boolean isMovable() {
				return false;
			}
		};
	}
	
	protected MoveBlockerMovable createMoveBlockerMovable() {
		return new MoveBlockerMovable();
	}

	public void assertMoveValidated() {
		assertTrue(checker.moveValidation(movable, speedVector));
	}

	public void denyMoveValidated(MoveBlocker... blockers) {
		assertFalse(checker.moveValidation(movable, speedVector));
		assertCorrectFoundBlockers(blockers);
	}

	public void assertCorrectFoundBlockers(MoveBlocker[] blockers) {
		assertEquals(new HashSet<MoveBlocker>(Arrays.asList(blockers)),
				new HashSet<MoveBlocker>(foundBlockers));
	}

	@Test
	public void validateWhenNoBlocker() {
		setSpeedVector(1, 1, 1);
		assertMoveValidated();
	}

	@Test
	public void validateWhenBlockerIsAway() throws Exception {
		checker.addMoveBlocker(createMoveBlocker(-100, -100, 1, 1));
		setSpeedVector(1, 1, 1);
		assertMoveValidated();
	}

	@Test
	public void dontValidateWhenBlockerIsBlocking() throws Exception {
		MoveBlocker blocker = createMoveBlocker(width, 0, 10, 10);
		checker.addMoveBlocker(blocker);
		setSpeedVector(1, 0, 1);
		denyMoveValidated(blocker);
	}

	@Test
	public void validateWhenBlockerIsRemoved() throws Exception {
		MoveBlocker blocker = createMoveBlocker(width, 0, 10, 10);
		checker.addMoveBlocker(blocker);
		setSpeedVector(1, 0, 1);
		denyMoveValidated(blocker);
		checker.removeMoveBlocker(blocker);
		assertMoveValidated();
	}
	
	@Test
	public void assertPlayerIsNotBlockingItself(){
		setSpeedVector(1, 1, 1);
		MoveBlockerMovable m = createMoveBlockerMovable();
		checker.addMoveBlocker(m);
		assertTrue(checker.moveValidation(m, speedVector));
	}

	class MoveBlockerMovable extends GameMovable implements MoveBlocker{
	
		@Override
		public Rectangle getBoundingBox() {
			return new Rectangle(0, 0, 10, 10);
		}
	
		@Override
		public void oneStepMoveAddedBehavior() {
			//Nothing 
		}
		
	}
	
}
