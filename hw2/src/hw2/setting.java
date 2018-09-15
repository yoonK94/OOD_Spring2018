package hw2;

import java.util.*;

public class setting {
	private int[] playerTypes;
	private Scanner sc = new Scanner(System.in);
	private boolean done = false;
	private int nextPlayer = 0;
	private int NUM_PLAYER;
	private game begin;
	
	//Initial question.
	public void initialSetting() {
		System.out.print("Please choose how many players are in the game : ");
		NUM_PLAYER = sc.nextInt();
		playerTypes = new int[NUM_PLAYER];
	}
	
	//Assign types to the players
	public int getCommand() {
		System.out.print("Please choose the type of player" + Integer.toString(nextPlayer + 1) +  " (1 = human player, 2 = timid player, 3 = crafy player) : ");
		return sc.nextInt();
	}
	public void processCommand(int cmd) {
		playerTypes[nextPlayer++] = cmd;
		if (nextPlayer == NUM_PLAYER) {
			done = true;
		}
	}
	
	//Indicate the end of the loop.
	public boolean isDone() {
		return done;
	}
	
	//Start the game with the desired setting.
	public void begin() {
		begin = new game(playerTypes, sc);
		while(begin.getWinner() < 0) {
			begin.elapseOneTurn();	
		}
		sc.close();
	}
	
	//Return the winner.
	public String theWinner() {
		return ("Congratulation! the winner of the Dice game is player" + Integer.toString(begin.getWinner()) + "!.");
	}
}
