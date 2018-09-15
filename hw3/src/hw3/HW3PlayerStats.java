package hw3;

import java.util.*;

public class HW3PlayerStats {
	
	private static gameConnection conn = new gameConnection("yoonKim.info");
	private static Map<String, Player> playerMap = conn.getMap();
	
	private static List<Player> playerL = new ArrayList<Player>(playerMap.values());
	
	public static void main(String[] args) {
		Collections.sort(playerL);
		System.out.println("List of players with the highest winning percentage: \n");
		for (Player p : playerL) 
			System.out.println(p);
		System.out.println("\nEnd of the list.");
	}
	
}
