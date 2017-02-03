package unnamed.motion;

import java.awt.Point;
import java.util.Random;

import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyRandom;
import gameframework.motion.MoveStrategyStraightLine;
import gameframework.motion.SpeedVector;

public class MoveStrategyStraightRandom implements MoveStrategy{

	protected int speed;
	protected int maxspeed;
	protected MoveStrategy straight;
	protected MoveStrategy random;
	
	public MoveStrategyStraightRandom(Point pos, Point goal, int speed){
		this.straight= new MoveStrategyStraightLine(pos,goal,speed);
		this.random= new MoveStrategyRandom(speed);
		this.maxspeed=speed;
	}
	
	@Override
	public int getSpeed() {
		return speed;
	}
	
	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	@Override
	public SpeedVector getSpeedVector() {
		
		Random r = new Random();
		
		if (r.nextInt(2) == 1){
				this.straight.setSpeed(maxspeed + r.nextInt(this.maxspeed/2 + 1));
				this.random.setSpeed(maxspeed + r.nextInt(this.maxspeed/2 + 1 ));
		}
		else{
			this.straight.setSpeed(maxspeed - r.nextInt(this.maxspeed/4 + 1));
			this.random.setSpeed(maxspeed - r.nextInt(this.maxspeed/4 + 1 ));
		}
		
		if (r.nextInt(5) == 1)
			return straight.getSpeedVector();
		else 
			return random.getSpeedVector();
		
		
	}
	
}
