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
		data.decreaseLife(5);
		this.getUniverse().removeGameEntity(c);
	}
	
	public void overlapRule(PlayerTest p, CageGood c){
		this.data.getScore().setValue(this.data.getScore().getValue()+1);
		Random r = new Random();
		int spriteSize = this.data.getConfiguration().getSpriteSize();
		data.increaseLife(1);
		this.getUniverse().removeGameEntity(c);
		c.setPosition(new Point((8+r.nextInt(22))*spriteSize,(8+r.nextInt(7))*spriteSize));
		this.getUniverse().addGameEntity(c);
		this.getUniverse().addGameEntity(new BadCage(this.data,new Point((20+r.nextInt(5))*spriteSize,(10+r.nextInt(5))*spriteSize),p.getPosition()));
	}

}
