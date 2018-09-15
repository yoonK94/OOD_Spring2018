package hw3;

import java.util.*;

public class Participants {
	private List<Player> players = new ArrayList<Player>();
	private int current = -1;  //initially, no player is current
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	public Player currentPlayer() {
		return players.get(current);
	}
	
	public Player nextPlayer() {
		current++;
		if (current == players.size())
			current = 0;
		return currentPlayer();
	}
	
	public List<Player> allPlayers() {
		return players;
	}
	
	public void reset() {
		for (Player p : players) {
			p.resetChips();
			p.addLoss();
		}
	}
}

