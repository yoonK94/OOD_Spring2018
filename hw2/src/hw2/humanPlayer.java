package hw2;

import java.util.*;

public class humanPlayer implements Player{
	
	private int chip = 0;
	private Scanner sc1;
	
	public humanPlayer(Scanner sc) {
		sc1 = sc;
	}
	
	public boolean decide(int roll, int chipInThePot, int TOP_CHIP) {
		
		//Must run the first die.
		if(roll == 1) {
			return true;
		}
		
		//Give useful information to the user.
		System.out.println("\nCurrently there are " + Integer.toString(chipInThePot) + " chips in the pot.");
		System.out.println("Top winning player has " + Integer.toString(TOP_CHIP) + " chips.");
		System.out.println("You will be rolling " + Integer.toString(roll) + " dice.");
		System.out.println("You have " + Integer.toString(chip) + " chips.");
		
		System.out.print("Please enter your command (0 = stop, 1 = go) : ");
		int decision = sc1.nextInt();
		
		//Return decision.
		if (decision == 0) {
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
