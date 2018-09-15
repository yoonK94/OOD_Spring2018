package hw3;

import java.io.*;

public abstract class Player implements Comparable<Player>,
										Serializable{
	
	protected String name;
	protected int chipswon = 0;
	protected int wins = 0;
	protected int losses = 0;
	
	protected Player(String name) {
		this.name = name;
	}
	
	public String name() {
		return name;
	}

	public int chipsWon() {	      
		return chipswon;	   
	}
   
	public void addChips(int n) {
		chipswon += n;
	}
	
	public void resetChips() {
		chipswon = 0;
	}
	
	public void addWin() {
		wins++;
		losses--;//no need to find the winner during reset process
	}
	
	public void addLoss() {
		losses++;
	}

	public String toString() {
		String playerType = getType();
		return name + " is a " + playerType + " with " 
				+ wins + " wins, " + losses 
				+ " losses, and winning percentage of " + getWinP(); 
	}
	
	public int compareTo(Player p) {
		int winP1 = getWinP();
		int winP2 = p.getWinP();
		if (winP1 == winP2) {
			return name().compareTo(p.name());
		}
		return winP2 - winP1;
	}
	
	private int getWinP(){
		return (int)(((double)wins/(wins+losses))*100);
	}
	
	public abstract boolean takeThePot(Participants p, int pot);
	protected abstract String getType();
	
	

}
