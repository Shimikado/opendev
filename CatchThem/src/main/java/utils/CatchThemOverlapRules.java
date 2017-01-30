package utils;

import entities.CatchThemBlueStar;
import entities.CatchThemCatcher;
import entities.CatchThemDeathBlock;
import entities.CatchThemGreenStar;
import entities.CatchThemWall;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

public class CatchThemOverlapRules extends OverlapRulesApplierDefaultImpl {

	public void overlapRule(CatchThemGreenStar s,CatchThemCatcher c){
		c.oneMorePoint();
		s.selfDestruct();
	}
	
	public void overlapRule(CatchThemGreenStar s,CatchThemDeathBlock d){
		s.selfDestruct();
		this.data.decreaseLife(1);
	}
	
	public void overlapRule(CatchThemGreenStar s,CatchThemWall d){
		s.selfDestruct();
	}
	
	public void overlapRule(CatchThemBlueStar s,CatchThemCatcher c){
		c.oneMorePoint();
		this.data.increaseLife(1);
		s.selfDestruct();
	}
	
	public void overlapRule(CatchThemBlueStar s,CatchThemDeathBlock d){
		s.selfDestruct();
		this.data.decreaseLife(1);
	}
	
	public void overlapRule(CatchThemBlueStar s,CatchThemWall d){
		s.selfDestruct();
	}
	
	public void overlapRule(CatchThemCatcher s,CatchThemWall d){

	}
}
