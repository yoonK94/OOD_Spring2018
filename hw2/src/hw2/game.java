package hw2;

import java.util.*;

public class game {
	
	private Player[] players;
	private int NUM_PLAYER;
	private int TOP_CHIP;
	private int current = 0;
	private int winner = -1;
	private int chipInThePot = 0;
	
	public game(int[] playerTypes, Scanner sc) {
		NUM_PLAYER = playerTypes.length;
		
		//Make an array of Player objects.
		players = new Player[NUM_PLAYER];
		for (int i = 0; i < NUM_PLAYER; i++) {
			if (playerTypes[i] == 1) {
				players[i] = new humanPlayer(sc);
			}
			else if (playerTypes[i] == 2) {
				players[i] = new timidPlayer();
			}
			else if (playerTypes[i] == 3) {
				players[i] = new craftyPlayer();
			}
		}
	}
	
	public void elapseOneTurn() {
		int roll = 1;
		boolean won = true;

		//Players decide whether they want to keep going after the first roll.
		while(players[current].decide(roll, chipInThePot, TOP_CHIP)) {
			
			//If decided, chips are added to the pot.
			chipInThePot += roll;
			
			//Roll the dice.
			if(this.didAce(roll)) {
				System.out.println("\nplayer" + Integer.toString(current + 1) + " aced out after " + Integer.toString(roll) + " rolls");
				won = false;
				break;
			}
			
			//Add one more die.
			roll++;
		}
		
		//If succeeded, take the coins in the pot.
		if (won) {
			System.out.println("\nplayer" + Integer.toString(current + 1) + " stopped after " + Integer.toString(roll - 1) + " rolls and won " + Integer.toString(chipInThePot) + " chips");
			players[current].addChip(chipInThePot);
			chipInThePot = 0;
		}
			
		//Print the latest result.
		this.printResult();
		
		//Update the top player and decide the victor if possible.
		int chip = players[current++].getChip();
		if (chip > TOP_CHIP) {
			if (chip >= 30) {
				winner = current;
			}
			TOP_CHIP = chip;		
		}

		//Display the end of cycle.
		if (current % NUM_PLAYER == 0) {
			System.out.println("\n\nEnd of a cycle\n\n");
			current = 0;
		}
	}

	//Roll the dice.
	private boolean didAce(int rolls) {
		boolean ace = false;
		for (int x = 0; x < rolls; x++)
			if((int)(Math.random() * 4) == 1) {
				ace = true;
				break;
			}
		return ace;
		
	}
	
	//Return winner or -1
	public int getWinner() {
		return winner;
	}

	//Print the latest result.
	private void printResult() {
		String chipCount = "Chip count:";
		for (int i = 0; i < NUM_PLAYER; i++) {
			chipCount += " player" + Integer.toString(i + 1) + ":" + Integer.toString(players[i].getChip());
		}
		System.out.println(chipCount);
		System.out.println("The pot contains " + Integer.toString(chipInThePot) + " chips.\n");
	}
}
