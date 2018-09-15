package hw5;

public class meanFactory extends FishFactory{
	public Fish create() {
		return new Fish(new MeanFish(), new ErraticBehavior());
	}
}