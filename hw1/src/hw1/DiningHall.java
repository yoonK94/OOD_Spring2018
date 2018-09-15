package hw1;

public class DiningHall {

	private CashRegister[] registers;
	private int CUST_ARRIVAL_PCT;
	private int NUM_REGISTERS;
	
	public DiningHall(int num, int pct) {
		CUST_ARRIVAL_PCT = pct;
		NUM_REGISTERS = num;
		registers  = new CashRegister[NUM_REGISTERS];
		for (int i = 0; i < NUM_REGISTERS; i++) {
			registers[i] = new CashRegister();
		}
	}
	
	public void elapseOneSecond(int currentTime) {
		if (aCustomerArrives()) {
			int chosenRegister = smallestRegister();
			registers[chosenRegister].newCustomer(currentTime);
		}
		for (int r = 0; r < NUM_REGISTERS; r++) {
			registers[r].elapseOneSecond(currentTime);
		}
	}
	
	private boolean aCustomerArrives() {
		int n = (int)(Math.random() * 100);
		return n < CUST_ARRIVAL_PCT;
	}
	
	private int smallestRegister() {
		int currentSmallest = 0;
		for (int r = 1; r < NUM_REGISTERS; r++) {
			if (registers[r].size() < registers[currentSmallest].size())
				currentSmallest = r;
		}
		return currentSmallest;
	}
	
	public String toString() {
		String result = "";
		for (int r = 0; r < NUM_REGISTERS; r++) {
			result += "Register " + r;
			result += registers[r].toString() + "\n";
		}
		return result;
	}
	
}
