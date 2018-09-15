package hw2;

import java.io.*;

public interface Player extends Serializable{
	
	//Make decision based on how many chips are in the pot and how many chips the top player has.
	boolean decide(int roll, int chipInThePot, int TOP_CHIP);
	
	//Return chips in position.
	int getChip();
	
	//Add won chips.
	void addChip(int moreChip);
}
