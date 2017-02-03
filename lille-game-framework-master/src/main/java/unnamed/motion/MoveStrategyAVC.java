package unnamed.motion;

import java.awt.Point;
import java.util.Random;

import gameframework.motion.MoveStrategy;
import gameframework.motion.SpeedVector;

public class MoveStrategyAVC implements MoveStrategy{

	protected int speed = 8;
	Point goal, currentPosition;
	static boolean onStraight = true;
	
	public MoveStrategyAVC(Point pos, Point goal, int speed){
		this.goal = goal;
		this.currentPosition = pos;
		this.speed = speed;
	}
	
	@Override
	public SpeedVector getSpeedVector(){
		Random rand = new Random();
		if(rand.nextInt(5000) == 50)
			onStraight = !onStraight;
		if(onStraight){
			double dist = currentPosition.distance(goal);
			int xDirection = (int) Math.rint((goal.getX() - currentPosition.getX())
					/ dist);
			int yDirection = (int) Math.rint((goal.getY() - currentPosition.getY())
					/ dist);
			SpeedVector move = new SpeedVector(new Point(xDirection, yDirection), rand.nextInt(10));
			return move;
		}
		else{
			int r = rand.nextInt(4);
					
			switch(r){
			case 0:
				return new SpeedVector(new Point(1,0), rand.nextInt(10));
			case 1:
				return new SpeedVector(new Point(-1,0), rand.nextInt(10));
			case 2:
				return new SpeedVector(new Point(0,-1), rand.nextInt(10));
			case 3:
				return new SpeedVector(new Point(0,1), rand.nextInt(10));
			default:
				throw new IllegalStateException();
			}
		}
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
