package hw2;

public class craftyPlayer implements Player{
	
	private int chip = 0;
	
	public boolean decide(int roll, int chipInThePot, int TOP_CHIP) {
		//Must run the first die.
		if (roll == 1) {
			return true;
		}
		
		//If sufficient amount of chips are in the pot, take the chips.
		else if(chip + chipInThePot > TOP_CHIP) {
			return false;
		}
		else {
			return true;
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
