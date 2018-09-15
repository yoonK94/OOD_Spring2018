package hw3;

import java.util.Scanner;

public class HumanPlayer extends Player{
    transient private Scanner sc;
   

	public HumanPlayer(String name, Scanner sc) {
		super(name);
		this.sc = sc;
	}
	
	public void setScanner(Scanner sc) {
		this.sc = sc;
	}
   
	public boolean takeThePot(Participants p, int pot) {
		String msg = name() + ": The pot contains " + pot + " chips. Cash out? (y/n)";
		System.out.print(msg);
		String response = sc.next();
		return response.toLowerCase().startsWith("y");
	}
	
	public String getType() {
		return "Human Player";
	}
}

