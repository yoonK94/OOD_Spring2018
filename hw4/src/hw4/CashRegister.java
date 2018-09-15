package hw4;

import java.util.*;

public class CashRegister {
   private int whoami;  // identifies the cash register
   private Cashier c;
   private List<Customer> custs = new LinkedList<Customer>();

   private int speed;
   private int numserved = 0;
   private int totalWaitTime = 0;
   private Customer currentCust = null;

   public CashRegister(int n, boolean fast) {
      whoami = n;
      if(fast) {
    	  c = new Fast();
      }
      else {
    	  c = new NormalSpeed();
      }
      speed = c.speed();
    	  
   }

   public void addCustomer(int t, int maxitem, String distT) {
      Customer c = new Customer(t, maxitem, distT);
      custs.add(c);
      if (currentCust == null)
         currentCust = c;
   }

   public void elapseOneSecond(int currentTime) {
	   for(int i = 0; i < speed; i++) {
		   // Return if there is no current customer.  
		  if (currentCust == null)
			   return;

		  // Otherwise, process the current customer.
          currentCust.elapseOneSecond();
	      if (currentCust.isFinished()) {
	         numserved++;
	         totalWaitTime += currentTime - currentCust.arrivalTime();
	
	         // Remove the finished customer and make the next customer current.
	         custs.remove(0);
	         currentCust = custs.size() > 0 ? custs.get(0) : null;
	      }
      }
   }

   public int size() { 
      return custs.size(); 
   }
   
   public String statistics() {
      return "Register " + whoami
            + "\tNumber served = " + numserved
            + "\tAverage wait time = " + avgWaitTime();	
   }

   public int getNumServed() {
	   return numserved;
   }
   
   public int avgWaitTime() { 
      return totalWaitTime / numserved; 
   }
}
