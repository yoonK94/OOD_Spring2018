package hw5;

public class puffFactory extends FishFactory{
	public Fish create() {
		return new Fish(new PufferFish(), new NormalBehavior());
	}
}
