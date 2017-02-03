package  groupe4.NicolasDoge.util;

import java.awt.Point;
import java.util.Random;

import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;
import groupe4.NicolasDoge.entities.Enemy;
import groupe4.NicolasDoge.entities.PlayerTest;
import groupe4.NicolasDoge.entities.ennemies.BadCage;
import groupe4.NicolasDoge.entities.ennemies.CageGood;

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
