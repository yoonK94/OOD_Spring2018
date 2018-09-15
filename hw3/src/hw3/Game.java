package hw3;

public class Game {
	public static final int GOAL = 30;

	private Dice dice = new Dice(4); // 4-sided dice
	private Participants participants;
	private int pot = 0;
	private boolean gameover = false;

	public Game(Participants p) {
		participants = p;
	}

	public Player play() {
		while (!gameover) {
			String whathappened = takeTurn();
			System.out.println(whathappened);
			System.out.println(status() + "\n");
		}
		participants.currentPlayer().addWin();
		return participants.currentPlayer();  // return the winner
	}
	

	private String takeTurn() {
		Player currentplayer = participants.nextPlayer();
		int numdice = 0;
		while (true) {
			numdice++;
			pot += numdice;
			if (!dice.roll(numdice)) 
				return currentplayer.name() + " aced out after " + numdice + " rolls";
			else {
				if (currentplayer.takeThePot(participants, pot)) {
					currentplayer.addChips(pot);
					int amtwon = pot;
					pot = 0;
					if (currentplayer.chipsWon() >= GOAL) {
						gameover = true;
						
					}
					return currentplayer.name() + " stopped after " + numdice + " rolls and won " + amtwon + " chips";
				}
			}
		}
	}
	
	private String status() {
		String result = "Chip count: ";
		for (Player player : participants.allPlayers()) 
			result += player.name() + ":" + player.chipsWon() + " ";
		result += "\nThe pot contains " + pot + " chips.";
		return result;
	}
}
