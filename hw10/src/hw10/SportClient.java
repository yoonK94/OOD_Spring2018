package hw10;

public class SportClient implements Client{
	private String name;
	
	public SportClient(String val, ScoreService ser) {
		ser.addObserver(this);
		name = val;
	}
	
	public void newScore(String sport, String hometeam, 
			String awayteam, String homescore, String awayscore) {
		if(name.equals(sport))
			System.out.println("New " + sport + " score: " + hometeam + " " + homescore + ", " + awayteam + " " + awayscore);
	}
}
