package  groupe4.NicolasDoge.util;

import gameframework.game.GameConfiguration;
import gameframework.motion.overlapping.OverlapRulesApplier;

public class Configuration extends GameConfiguration{
	public Configuration(int nbRows, int nbColumns, int spriteSize,
			int nbLives){
		super(nbRows,nbColumns,spriteSize,nbLives);
	}
	
	@Override
	public OverlapRulesApplier createOverlapRulesApplier() {
		return new EntityRule();
	}
}
