package hw3;

import java.util.*;

public class HW3DiceGame {
	
	private static gameConnection conn = new gameConnection("yoonKim.info");
	private static Map<String, Player> playerMap = conn.getMap();
	
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Participants participants = determinePlayers();
		Game game = new Game(participants);
		Player winner = game.play();
		System.out.println("The winner is " + winner.name() + ", with " + winner.chipsWon() + " chips.");
		participants.reset();
		conn.saveMap(playerMap);
		sc.close();
	}

	private static Participants determinePlayers() {
		Participants participants = new Participants();
		System.out.print("How many players? ");
		int numplayers = sc.nextInt();
		for (int i=0; i<numplayers; i++) {
			System.out.println("Enter player name ");
			String pname = sc.next();
			
			Player tempP = playerMap.get(pname);
			
			if(tempP == null) {
				System.out.println("New player joined");
				System.out.println("Enter player type (human=0, timid bot=1, crafty bot=2)");
				int ptype = sc.nextInt();
				
				if (ptype == 0)
					tempP = new HumanPlayer(pname, sc);
				else if (ptype == 1)
					tempP = new TimidPlayer(pname);
				else
					tempP = new CraftyPlayer(pname);
				
				playerMap.put(pname, tempP);
			}
			else {
				System.out.println("Retrived existing profile of " + pname);
				if (tempP instanceof HumanPlayer) {
					((HumanPlayer) tempP).setScanner(sc);
				}
			}
			participants.addPlayer(tempP);
		}
		return participants;
	}
	
}
