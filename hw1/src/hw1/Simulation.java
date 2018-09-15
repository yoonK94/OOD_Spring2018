package hw1;

public class Simulation {
	
	private static int SIMULATION_TIME = 100000;
	private static int NUM_REGISTERS = 4;
	private static int CUST_ARRIVAL_PCT = 15;
	private static DiningHall diningHall;
	
	public static void main(String[] args) {
		diningHall = new DiningHall(NUM_REGISTERS, CUST_ARRIVAL_PCT);
		for (int t= 0; t < SIMULATION_TIME; t++) {
			diningHall.elapseOneSecond(t);
		}
		System.out.println(diningHall.toString());
	}
}
