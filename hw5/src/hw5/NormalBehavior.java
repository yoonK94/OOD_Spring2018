package hw5;


public class NormalBehavior extends FishBehavior{
	public NormalBehavior() {
		xspeed = 2.0;
		yspeed = 1.0;
		xDirectionChangePct = 0.1; // the fish changes horizontal direction 0.1% of the time
		yDirectionChangePct = 0.5; // the fish changes vertical direction 0.5% of the time	
		xPosStrat = 1.0/3;
		yPosStrat = 1.0/3;
	}
}
