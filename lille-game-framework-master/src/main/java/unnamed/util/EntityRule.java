package unnamed.util;

import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;
import unnamed.entities.PlayerTest;
import unnamed.entities.ennemies.Cage;

public class EntityRule extends OverlapRulesApplierDefaultImpl {
	public void overlapRule(PlayerTest p, Cage c)  {
		data.decreaseLife(1);
	}

}
