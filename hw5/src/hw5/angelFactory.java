package hw5;

public class angelFactory extends FishFactory{
	public Fish create() {
		return new Fish(new AngelFish(), new NormalBehavior());
	}
}
