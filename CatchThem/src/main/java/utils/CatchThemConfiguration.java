package utils;

import gameframework.game.GameConfiguration;
import gameframework.motion.overlapping.OverlapRulesApplier;

/**
 * CatchThemConfigurations. Return specific configurations and OverlapRulesApplier. 
 * @author guntau
 *
 */
public class CatchThemConfiguration extends GameConfiguration {
	
	
	public CatchThemConfiguration() {
		super(32,28,16,3);
	}	
	@Override
	public OverlapRulesApplier createOverlapRulesApplier() {
		return new CatchThemOverlapRules();
	}
	
}
