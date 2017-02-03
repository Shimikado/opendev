package unnamed.util;

import java.awt.Point;
import java.util.Random;

import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;
import unnamed.entities.Enemy;
import unnamed.entities.PlayerTest;
import unnamed.entities.ennemies.BadCage;
import unnamed.entities.ennemies.CageGood;

public class EntityRule extends OverlapRulesApplierDefaultImpl {
	public void overlapRule(PlayerTest p, BadCage c)  {
		scorer(c,-1);
	}
	
	public void overlapRule(PlayerTest p, CageGood c){
		scorer(c,1);
	}
	
	private void scorer(Enemy c, int score){
		Random r = new Random();
		int spriteSize = this.data.getConfiguration().getSpriteSize();
		data.increaseLife(score);
		this.getUniverse().removeGameEntity(c);
		c.setPosition(new Point((8+r.nextInt(22))*spriteSize,(8+r.nextInt(7))*spriteSize));
		this.getUniverse().addGameEntity(c);
	}
}
