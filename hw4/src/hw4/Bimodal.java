package hw4;

public class Bimodal implements ItemDistribution{
	public int howmany(int maxitem) {
		int choose = (int)(Math.random() * 3);
		  if(choose == 0)
			  return 1;
		  else if(choose == 1)
			  return maxitem/2;
		  else
			  return maxitem;
	}
}
