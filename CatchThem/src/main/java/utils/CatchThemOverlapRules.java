package utils;

import entities.CatchThemCatcher;
import entities.CatchThemDeathBlock;
import entities.CatchThemStar;
import entities.CatchThemWall;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

public class CatchThemOverlapRules extends OverlapRulesApplierDefaultImpl {

	public void overlapRule(CatchThemStar s,CatchThemCatcher c){
		c.oneMorePoint();
		s.selfDestruct();
	}
	
	public void overlapRule(CatchThemStar s,CatchThemDeathBlock d){
		s.selfDestruct();
		this.data.decreaseLife(1);
	}
	
	public void overlapRule(CatchThemStar s,CatchThemWall d){
		s.selfDestruct();
	}
	
	public void overlapRule(CatchThemCatcher s,CatchThemWall d){

	}
}
