package hw5;

public class octoFactory extends FishFactory{
	public Fish create() {
		return new Fish(new Octopus(), new BottomFeedingBehavior());
	}
}
