package hw2;

public class timidPlayer implements Player{
	
	private int chip = 0;
	
	public boolean decide(int roll, int chipInThePot, int TOP_CHIP) {
		//Must run the first die.
		if (roll == 1) {
			return true;
		}
		
		//Cash out as soon as possible.
		else {
			return false;
		}
	}
	
	//Return chips in position.
	public int getChip() {
		return chip;
	}
	
	//Add won chips.
	public void addChip(int moreChip) {
		chip += moreChip;
	}
}
