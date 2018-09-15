package hw5;


public abstract class FishBehavior {
	
	protected double xspeed;
	protected double yspeed;
	protected double xDirectionChangePct; // the fish changes horizontal direction 0.1% of the time
	protected double yDirectionChangePct; // the fish changes vertical direction 0.5% of the time	
	protected double xPosStrat;
	protected double yPosStrat;
	
	public double getXSpeed() {
		return xspeed;
	}
	
	public double getYSpeed() {
		return yspeed;
	}
	
	public double getXChangePCT() {
		return xDirectionChangePct;
	}
	
	public double getYChangePCT() {
		return yDirectionChangePct;
	}
	
	public double getXInitialPos() {
		return xPosStrat;
	}
	
	public double getYInitialPos() {
		return yPosStrat;
	}
	
	public void changeXdirection() {
	      xspeed = -xspeed;
	}
	   
	public void changeYdirection() {
	      yspeed = -yspeed;
	}
	
	public boolean movesRight() {
		return xspeed >= 0;
	}
}
