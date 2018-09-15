package hw4;

public class Uniform implements ItemDistribution{
	public int howmany(int maxitem) {
		return  1 + (int)(Math.random() * maxitem);
	}
}
