package hw5;


public class ErraticBehavior extends FishBehavior{
	public ErraticBehavior() {
		xspeed = 5.0;
		yspeed = 3.0;
		xDirectionChangePct = 0.5; // the fish changes horizontal direction 0.1% of the time
		yDirectionChangePct = 1.0; // the fish changes vertical direction 0.5% of the time	
		xPosStrat = Math.random();
		yPosStrat = Math.random();
	}
}
