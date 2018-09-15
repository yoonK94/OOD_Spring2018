package hw2;

public class HW2DiceGame {
	
	public static void main(String[] args) {
		//initial setting to pass number and types of players to the game class.
		setting set = new setting();
		set.initialSetting();
		while(!set.isDone()) {
			int cmd = set.getCommand();
			set.processCommand(cmd);
		}
		
		//Start the game.
		set.begin();
		
		//Print the result.
		System.out.println(set.theWinner());
	}
}
