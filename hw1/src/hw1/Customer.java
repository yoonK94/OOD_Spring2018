package hw1;

public class Customer {
	private int arrivalTime;
	private int serviceTime;
	
	public Customer(int currentTime) {
		arrivalTime = currentTime;
		int howManyItems = (int)(Math.random() * 10);
		serviceTime = 2 * (howManyItems + 1) + 10;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getServiceTime() {
		return serviceTime;
	}
	
	public void elapseOneSecond() {
		serviceTime--;
	}
}
