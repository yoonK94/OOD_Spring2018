package hw10;

public class TeamClient implements Client{
	private String name;
	
	public TeamClient(String val, ScoreService ser) {
		ser.addObserver(this);
		name = val;
	}
	
	public void newScore(String sport, String hometeam, 
			String awayteam, String homescore, String awayscore) {
		if(name.equals(hometeam))
			System.out.println("New score in " + hometeam + " " + sport + ": " + hometeam + " " + homescore + ", " + awayteam + " " + awayscore);
		else if(name.equalsIgnoreCase(awayteam))
			System.out.println("New score in " + awayteam + " " + sport + ": " + awayteam + " " + awayscore + ", " + hometeam + " " + homescore);
	}
}
