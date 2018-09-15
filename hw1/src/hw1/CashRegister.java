package hw1;

import java.util.*;

public class CashRegister {
	private int customersServed;
	private int totalWaitTimes;
	private List<Customer> times; 
	
	public CashRegister() {
		times = new LinkedList<Customer>();
		customersServed = 0;
		totalWaitTimes = 0;
		
	}
	
	public void newCustomer(int currentTime) {
		times.add(new Customer(currentTime));
	}
	
	public void elapseOneSecond(int currentTime) {
		if(times.size() == 0) {
			return;
		}
		
		if (times.get(0).getServiceTime() - 1  > 0){
			times.get(0).elapseOneSecond();
		}
		else {
			customersServed++;
			totalWaitTimes += currentTime - times.get(0).getArrivalTime();
			times.remove(0);
		}
	}
	
	public int size() {
		return times.size();
	}
	
	public String toString() {
		String result = "\n\tNumber of arrivals = " + customersServed;
		result += "\n\tAverage wait time = " + (totalWaitTimes / customersServed);
		return result;
	}
	
}
