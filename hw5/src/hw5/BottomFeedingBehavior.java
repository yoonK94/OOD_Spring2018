package hw5;

public class BottomFeedingBehavior extends FishBehavior{
	public BottomFeedingBehavior() {
		xspeed = 0.5;
		yspeed = 0.0;
		xDirectionChangePct = 0.1; // the fish changes horizontal direction 0.1% of the time
		yDirectionChangePct = 0; // the fish changes vertical direction 0.5% of the time	
		xPosStrat = Math.random();
		yPosStrat = 1.0;
	}
}
